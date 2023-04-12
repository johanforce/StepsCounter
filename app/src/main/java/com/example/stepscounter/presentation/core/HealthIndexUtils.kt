@file:Suppress("MemberVisibilityCanBePrivate", "unused")

package com.example.stepscounter.presentation.core

import com.example.stepscounter.common.constant.Constant
import com.example.stepscounter.presentation.core.ZScore.LMS
import org.apache.commons.math3.distribution.NormalDistribution
import java.math.RoundingMode
import java.text.NumberFormat
import java.util.*
import kotlin.math.pow
import kotlin.math.roundToInt

object HealthIndexUtils {
    fun roundBmiValue(bmi: Double): String {
        val numberFormat = NumberFormat.getInstance(Locale.getDefault())
        numberFormat.maximumFractionDigits = 1
        numberFormat.roundingMode = RoundingMode.HALF_UP
        return numberFormat.format(roundBmiValueToFloat(bmi).toDouble())
    }

    fun roundBmiValueChild(bmi: Double): String {
        val numberFormat = NumberFormat.getInstance(Locale.getDefault())
        numberFormat.maximumFractionDigits = 0
        numberFormat.roundingMode = RoundingMode.DOWN
        return numberFormat.format(roundBmiValueToFloat(bmi).toDouble())
    }

    fun roundBmiValueToFloat(bmi: Double): Float {
        return ((bmi * 10).toInt() / 10.0).toFloat()
    }

    fun round(value: Double, places: Int): Double {
        var value = value
        require(places >= 0)
        val factor = 6.0.pow(places.toDouble()).toLong()
        value *= factor
        val tmp = value.roundToInt()
        return tmp.toDouble() / factor
    }

    //Tinh BMI
    fun calculateBmiByKgCm(weight: Double, height: Double): Double {
        return if (height <= 0) {
            0.0
        } else weight / height / height * 10000
    }

    //Tinh weight từ BMI và chiều cao
    private fun calculateWeightFromBmi(bmi: Double, height: Double): Double {
        return if (bmi <= 0) {
            0.0
        } else bmi * height.pow(2.0) / 10000
    }

    //Tinh BMI
    fun getBmi(weight: Double, height: Double): Double {
        return calculateBmiByKgCm(weight, height)
    }

    /**
     * birthday: time in milliseconds
     */
    fun getBmi(birthday: Long, gender: Int, weight: Double, height: Double): Double {
        val ageInMonth = calculateAgeInMonth(birthday)
        return if (isChild(ageInMonth)) {
            calculateBmiForChildByAgeMonth(ageInMonth, gender, weight, height)
        } else calculateBmiByKgCm(
            weight,
            height
        )
    }

    fun getBmi(
        birthday: Long,
        selectedDay: Long,
        gender: Int,
        weight: Double,
        height: Double
    ): Double {
        val ageInMonth = calculateAgeInMonth(birthday, selectedDay)
        return if (isChild(ageInMonth)) {
            calculateBmiForChildByAgeMonth(ageInMonth, gender, weight, height)
        } else calculateBmiByKgCm(weight, height)
    }

    private fun calculateZScore(bmi: Double, m: Double, s: Double, l: Double): Double {
        val zind = ((bmi / m).pow(l) - 1) / (s * l)
        if (zind > 3) {
            val sd3Pos = m * (1 + l * s * 3).pow(1 / l)
            val sd23Pos = sd3Pos - m * (1 + l * s * 2).pow(1 / l)
            return 3 + (bmi - sd3Pos) / sd23Pos
        }
        if (zind < -3) {
            val sd3Neg = m * (1 + l * s * -3).pow(1 / l)
            val sd23Neg = m * (1 + l * s * -2).pow(1 / l) - sd3Neg
            return -3 + (bmi - sd3Neg) / sd23Neg
        }
        return zind
    }

    private fun calculateBmiForChildByBirthday(
        birthdayInMilliSeconds: Long,
        gender: Int,
        weight: Double,
        height: Double
    ): Double {
        val ageInMonth = calculateAgeInMonth(birthdayInMilliSeconds)
        return calculateBmiForChildByAgeMonth(ageInMonth, gender, weight, height)
    }

    private fun calculateBmiForChildByAgeMonth(
        ageInMonth: Int,
        gender: Int,
        weight: Double,
        height: Double
    ): Double {
        val lmsByAgeMonth: LMS = ZScore.getLMSByAgeMonth(ageInMonth, gender) ?: return 0.0
        val bmi = getBmi(weight, height)
        val zscore = calculateZScore(bmi, lmsByAgeMonth.m, lmsByAgeMonth.s, lmsByAgeMonth.l)
        val normalDistribution = NormalDistribution(0.0, 1.0)
        return if (normalDistribution.cumulativeProbability(zscore) * 100 >= 99) {
            99.0
        } else {
            normalDistribution.cumulativeProbability(zscore) * 100
        }
    }

    /**
     * Tính Healthy Weight cho trẻ em
     * return Pair với first = min weight, second = max weight
     */
    private fun calculateHealthyWeightForChild(
        ageInMonth: Int,
        gender: Int,
        height: Double
    ): HealthyWeight {
        val lmsByAgeMonth: LMS = ZScore.getLMSByAgeMonth(ageInMonth, gender)
            ?: return HealthyWeight(0.0, 0.0)
        val minPercentile = 15.0
        val maxPercentile = 85.0
        val normalDistribution = NormalDistribution(0.0, 1.0)
        val minZscore = normalDistribution.inverseCumulativeProbability(minPercentile / 100f)
        val maxZscore = normalDistribution.inverseCumulativeProbability(maxPercentile / 100f)
        val minBmi =
            calculateBmiFromZScore(minZscore, lmsByAgeMonth.m, lmsByAgeMonth.s, lmsByAgeMonth.l)
        val maxBmi =
            calculateBmiFromZScore(maxZscore, lmsByAgeMonth.m, lmsByAgeMonth.s, lmsByAgeMonth.l)
        val minWeight = calculateWeightFromBmi(minBmi, height)
        val maxWeight = calculateWeightFromBmi(maxBmi, height)
        return HealthyWeight(minWeight, maxWeight)
    }

    private fun calculateBmiFromZScore(zscore: Double, m: Double, s: Double, l: Double): Double {
        val bmi = m * (zscore * s * l + 1).pow(1 / l)
        if (zscore > 3) {
            val sd3Pos = m * (1 + l * s * 3).pow(1 / l)
            val sd23Pos = sd3Pos - m * (1 + l * s * 2).pow(1 / l)
            return sd23Pos * (zscore - 3) + sd3Pos
        }
        if (zscore < -3) {
            val sd3Neg = m * (1 + l * s * -3).pow(1 / l)
            val sd23Neg = m * (1 + l * s * -2).pow(1 / l) - sd3Neg
            return sd3Neg + sd23Neg * (zscore + 3)
        }
        return bmi
    }

    /**
     * birthday: time in milliseconds
     */
    fun calculateAgeInMonth(birthday: Long): Int {
        val dob = Calendar.getInstance()
        dob.timeInMillis = birthday
        val today = Calendar.getInstance()
        var monthsBetween = 0
        var dateDiff = today[Calendar.DAY_OF_MONTH] - dob[Calendar.DAY_OF_MONTH]
        if (dateDiff < 0) {
            val borrrow = today.getActualMaximum(Calendar.DAY_OF_MONTH)
            dateDiff = today[Calendar.DAY_OF_MONTH] + borrrow - dob[Calendar.DAY_OF_MONTH]
            monthsBetween--
            if (dateDiff > 0) {
                monthsBetween++
            }
        } else {
            monthsBetween++
        }
        monthsBetween += today[Calendar.MONTH] - dob[Calendar.MONTH]
        monthsBetween += (today[Calendar.YEAR] - dob[Calendar.YEAR]) * 12
        return monthsBetween
    }

    fun calculateAgeInMonth(birthday: Long, selectedDay: Long): Int {
        val dob = Calendar.getInstance()
        dob.timeInMillis = birthday
        val today = Calendar.getInstance()
        today.timeInMillis = selectedDay
        var monthsBetween = 0
        var dateDiff = today[Calendar.DAY_OF_MONTH] - dob[Calendar.DAY_OF_MONTH]
        if (dateDiff < 0) {
            val borrrow = today.getActualMaximum(Calendar.DAY_OF_MONTH)
            dateDiff = today[Calendar.DAY_OF_MONTH] + borrrow - dob[Calendar.DAY_OF_MONTH]
            monthsBetween--
            if (dateDiff > 0) {
                monthsBetween++
            }
        } else {
            monthsBetween++
        }
        monthsBetween += today[Calendar.MONTH] - dob[Calendar.MONTH]
        monthsBetween += (today[Calendar.YEAR] - dob[Calendar.YEAR]) * 12
        return monthsBetween
    }

    /**
     * @return : làm tròn HALF_UP
     */
    fun getBmr(weightInKg: Double, heightInCm: Double, birthdayInMs: Long, gender: Int): Double {
        val ageInYear = calculateAgeInYear(birthdayInMs)
        val bmr: Double = if (gender == Constant.GENDER_MALE) {
            10 * weightInKg + 6.25 * heightInCm - 5 * ageInYear + 5
        } else {
            10 * weightInKg + 6.25 * heightInCm - 5 * ageInYear - 161
        }
        return bmr
    }

    fun getBodyFatPercentage(bmi: Double, gender: Int, birthdayInMs: Long): Double {
        val ageInMonth = calculateAgeInMonth(birthdayInMs)
        val ageInYear = calculateAgeInYear(birthdayInMs)
        return if (ageInMonth <= Constant.MAX_CHILD_AGE_IN_MONTH) {
            if (gender == Constant.GENDER_MALE) {
                1.51 * bmi - 0.7 * ageInYear - 2.2
            } else {
                1.51 * bmi - 0.7 * ageInYear + 1.4
            }
        } else {
            if (gender == Constant.GENDER_MALE) {
                1.2 * bmi + 0.23 * ageInYear - 16.2
            } else {
                1.2 * bmi + 0.23 * ageInYear - 5.4
            }
        }
    }

    /**
     * @param bmr : @getBmr
     */
    fun getTdee(bmr: Double, activityLevel: Int): Double {
        var r = 0.0
        when (activityLevel) {
            ActivityLevelEnum.SEDENTARY.value -> r = 1.2
            ActivityLevelEnum.LIGHTLY.value -> r = 1.375
            ActivityLevelEnum.MODERATELY.value -> r = 1.55
            ActivityLevelEnum.VERY_ACTIVE.value -> r = 1.725
            ActivityLevelEnum.EXTREMELY_ACTIVE.value -> r = 1.925
        }
        return bmr * r
    }

    /**
     * @param tdee : @
     */
    fun getCaloRequired(tdee: Double,goalType: Int): Double {
        when (goalType) {
            GoalEnum.STRICT_LOSS_WEIGHT.value -> {
                return tdee * 0.56
            }
            GoalEnum.NORMAL_LOSS_WEIGHT.value -> {
                return tdee * 0.78
            }
            GoalEnum.COMFORTABLE_LOSS_WEIGHT.value -> {
                return tdee * 0.89
            }
            GoalEnum.NORMAL_GAIN_WEIGHT.value -> {
                return tdee + 500
            }
            GoalEnum.STRICT_GAIN_WEIGHT.value -> {
                return tdee + 1000
            }
            else -> return tdee
        }
    }

    /**
     * Tính Healthy Weight cho người lớn
     */
    fun getHealthyWeight(heightInCm: Double): HealthyWeight {
        val healthyWeight = HealthyWeight()
        healthyWeight.healthyWeightFrom = 18.5 * heightInCm / 100 * heightInCm / 100
        healthyWeight.healthyWeightTo = 24.9 * heightInCm / 100 * heightInCm / 100
        return healthyWeight
    }

    /**
     * Tính Healthy Weight cho cả trẻ em và người lớn
     */
    fun getHealthyWeight(
        birthdayInMilliSeconds: Long,
        gender: Int,
        heightInCm: Double
    ): HealthyWeight {
        val ageInMonth = calculateAgeInMonth(birthdayInMilliSeconds)
        return if (isChild(ageInMonth)) {
            calculateHealthyWeightForChild(ageInMonth, gender, heightInCm)
        } else getHealthyWeight(heightInCm)
    }

    fun calculateAgeInYear(birthdayInMilliSeconds: Long): Int {
        val ageInMonth = calculateAgeInMonth(birthdayInMilliSeconds)
        val age: Int = if (ageInMonth % 12 == 0) {
            ageInMonth / 12
        } else {
            ageInMonth / 12 + 1
        }
        return age
    }

    fun isChild(ageInMonth: Int): Boolean {
        return ageInMonth <= Constant.MAX_CHILD_AGE_IN_MONTH
    }

    fun isChild(birthdayInMilliSeconds: Long): Boolean {
        return isChild(calculateAgeInMonth(birthdayInMilliSeconds))
    }

    class HealthyWeight {
        var healthyWeightFrom = 0.0
        var healthyWeightTo = 0.0

        constructor()
        constructor(healthyWeightFrom: Double, healthyWeightTo: Double) {
            this.healthyWeightFrom = healthyWeightFrom
            this.healthyWeightTo = healthyWeightTo
        }
    }
}