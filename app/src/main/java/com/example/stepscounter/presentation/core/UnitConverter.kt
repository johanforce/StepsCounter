@file:Suppress("MemberVisibilityCanBePrivate", "unused")

package com.example.stepscounter.presentation.core

import android.util.Pair
import java.math.BigDecimal
import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.text.NumberFormat
import java.util.*
import kotlin.math.roundToInt

object UnitConverter {
    private val suffixes: NavigableMap<Long, String> = TreeMap()
    private const val KM_MILE_CONST = 0.6213712f
    private const val CM_IN_CONST = 0.39370f
    private const val PACE_CONST =
        16.666666f // 1 m/s = 16.6666667 minutes/km hoac 1 min/km = 16.666666666667 mps(met per second)
    private const val FEET_CONST = 3.28084f // 1 m = 3.28084 feet or 1/0.3048
    private const val FEET_TO_MILES_CONST = 1 / 5280f // 1 m = 3.28084 feet or 1/0.3048
    private const val FOOT_TO_INCH = 12f // 1 foot = 12 inch

    init {
        suffixes[1000L] = "k"
        suffixes[1000000L] = "m"
        suffixes[1000000000L] = "b"
        suffixes[1000000000000L] = "t"
        suffixes[1000000000000000L] = "q"
        suffixes[1000000000000000000L] = "u"
    }

    fun formatDoubleToFloat(value: Double, digit: Int): Float {
        return BigDecimal(value.toString()).setScale(digit, RoundingMode.HALF_UP).toFloat()
    }

    fun convertSecondsToHours(durationInSeconds: Int): Double {
        return formatDouble(durationInSeconds / 3600.0, 4)
    }

    fun formatLong(value: Int): String {
        val decimalFormat = DecimalFormat("###,###,###")
        return decimalFormat.format(value.toLong())
    }

    fun formatLong(value: Long): String {
        val decimalFormat = DecimalFormat("###,###,###")
        return decimalFormat.format(value)
    }

    fun formatDoubleToString(value: Double?, digit: Int): String {
        val numberFormat = NumberFormat.getInstance()
        numberFormat.maximumFractionDigits = digit
        numberFormat.roundingMode = RoundingMode.HALF_UP
        return numberFormat.format(value)
    }

    fun formatDoubleToStringDown(value: Double?, digit: Int): String {
        val numberFormat = NumberFormat.getInstance()
        numberFormat.maximumFractionDigits = digit
        numberFormat.roundingMode = RoundingMode.HALF_DOWN
        return numberFormat.format(value)
    }

    fun formatDouble(toDouble: Double, digit: Int): Double {
        return BigDecimal(toDouble.toString() + "").setScale(digit, RoundingMode.HALF_UP).toDouble()
    }

    fun formatFloat(value: Float, digit: Int): Double {
        return BigDecimal(value.toString()).setScale(digit, RoundingMode.HALF_UP).toDouble()
    }

    fun calculateDistanceTravelledInKM(stepsTaken: Long, entityStrideLength: Double): Double {
        return formatDouble(stepsTaken * entityStrideLength / 1000, 2)
    }

    fun calculateDistanceTravelledInMet(steps: Long, distanceMetStep: Double): Double {
        return formatDouble(steps * distanceMetStep, 2)
    }

    fun convertDecimalToString(value: Any?): String {
        val df = DecimalFormat("#,##0")
        df.decimalFormatSymbols = DecimalFormatSymbols(Locale.getDefault())
        return df.format(value)
    }

    fun convertHourToMin(hour: Double): Double {
        return hour * 60
    }

    fun convertMetToKmOrMile(met: Double, isKm: Boolean): Double {
        val km = met / 1000
        return if (isKm) km else km * KM_MILE_CONST
    }

    fun convertSpeedMetPerSecToKmPerHour(speedMetPerSec: Double): Double {
        return speedMetPerSec * 3.6
    }

    fun convertCmToCmOrInch(cm: Double, isKm: Boolean): Double {
        return if (isKm) cm else cm * CM_IN_CONST
    }

    fun convertPaceMinPerKmToMinPerMile(paceMinPerKm: Double): Double {
        return paceMinPerKm / KM_MILE_CONST
    }

    fun convertPaceMinPerMileToMinPerKm(paceMinPerMile: Double): Double {
        return paceMinPerMile * KM_MILE_CONST
    }

    fun convertSpeedKmPerHourToMilePerHour(speedKmPerHour: Double): Double {
        return speedKmPerHour * KM_MILE_CONST
    }

    fun convertSpeedKmPerHourToMetPerSec(speedKmPerHour: Double): Double {
        return speedKmPerHour / 3.6
    }

    fun convertSpeedMilePerHourToKmPerHour(speedMilePerHour: Double): Double {
        return speedMilePerHour / KM_MILE_CONST
    }

    fun convertSpeedMetPSToSpeedKmOrMi(speedMetPerSec: Double, isKm: Boolean): Double {
        if (speedMetPerSec <= 0.01) {
            return 0.0
        }
        val speedKmH = speedMetPerSec * 3.6
        return if (isKm) speedKmH else speedKmH * KM_MILE_CONST
    }

    fun convertSpeedMetPSToPace(speedMetPerSec: Double, isKm: Boolean): Double {
        if (speedMetPerSec <= 0.01) {
            return 0.0
        }
        val paceMinPerKm = PACE_CONST / speedMetPerSec
        return if (isKm) paceMinPerKm else paceMinPerKm / KM_MILE_CONST //Conversion base : 1 min/km = 1.609344 min/mile
    }

    fun convertSpeedMetPSToPace(speedMetPerSec: Double): Double {
        return if (speedMetPerSec <= 0.01) {
            0.0
        } else PACE_CONST / speedMetPerSec
    }

    fun convertSpeedMSToPaceOrSpeedString(
        speedMs: Double,
        isCycling: Boolean,
        isKm: Boolean
    ): String {
        val paceOrSpeedStr: String
        val speedOrPace = formatDouble(convertSpeedMsToSpeedKmhOrPace(speedMs, isCycling, isKm), 1)
        if (isCycling) {
            paceOrSpeedStr = formatDoubleToString(speedOrPace, 1)
        } else {
            // dinh dang 5:3 min/km or 5:3 min/mi
            val minute = speedOrPace.toInt()
            val second = ((speedOrPace - minute) * 60).toInt()
            var secondStr = second.toString()
            var minuteStr = minute.toString()
            if (second < 10) {
                secondStr = "0$secondStr"
            }
            if (minute < 10) {
                minuteStr = "0$minute"
            }
            paceOrSpeedStr = "$minuteStr:$secondStr"
        }
        return paceOrSpeedStr
    }

    fun convertSpeedMSToPaceOrSpeedStrToSpeak(
        speedMs: Double,
        isCycling: Boolean,
        isKm: Boolean
    ): String {
        val paceOrSpeedStr: String
        val speedOrPace = formatDouble(convertSpeedMsToSpeedKmhOrPace(speedMs, isCycling, isKm), 1)
        if (isCycling) {
            paceOrSpeedStr = formatDoubleToString(speedOrPace, 1)
        } else {
            // dinh dang 5:3 min/km or 5:3 min/mi
            val minute = speedOrPace.toInt()
            val minuteStr = minute.toString()
            val second = ((speedOrPace - minute) * 60).toInt()
            if (second == 0) {
                return minuteStr
            }
            var secondStr = second.toString()
            if (second < 10) {
                secondStr = "0$secondStr"
            }
            paceOrSpeedStr = "$minuteStr:$secondStr"
        }
        return paceOrSpeedStr
    }

    fun convertSpeedMsToSpeedKmhOrPace(
        speedMetPerSec: Double,
        isCycling: Boolean,
        isKm: Boolean
    ): Double {
        if (speedMetPerSec <= 0.01) {
            return 0.0
        }
        return if (isCycling) { // neu la dap xe thi tra ra la speed
            convertSpeedMetPSToSpeedKmOrMi(speedMetPerSec, isKm) //km/h
        } else convertSpeedMetPSToPace(speedMetPerSec, isKm)

        // di chay bo se la pace
    }

    fun convertPaceMinPerKmToSpeedKmPerHour(paceMinPerKm: Double): Double {
        return if (paceMinPerKm <= 0) {
            0.0
        } else 60 / paceMinPerKm
    }

    fun convertPaceMinPerKmToSpeedMeterPerSecond(paceMinPerKm: Double): Double {
        return if (paceMinPerKm <= 0) {
            0.0
        } else 50 / (3 * paceMinPerKm)
    }

    fun convertKilometersToMiles(km: Float): Float {
        return km * KM_MILE_CONST
    }

    fun convertKilometersToMeters(km: Double): Double {
        return km * 1000
    }

    fun convertMetToMiles(met: Double): Double {
        val km = met / 1000
        return km * KM_MILE_CONST
    }

    fun convertMileToMeter(mile: Double): Double {
        return mile * 1609.34
    }

    fun convertFeetToInch(foot: Double): Double {
        return foot * FOOT_TO_INCH
    }

    fun convertInchToFeet(inch: Double): Double {
        return inch / FOOT_TO_INCH
    }

    fun convertKgToLbs(kg: Double): Double {
        return kg * 2.2046226218
    }

    fun convertKgToLbsIfNeed(kg: Double, isMetricUnit: Boolean): Double {
        return if (isMetricUnit) {
            kg
        } else {
            convertKgToLbs(kg)
        }
    }

    fun convertLbsToKg(lbs: Double): Double {
        return lbs / 2.2046226218
    }

    fun convertCmToInch(cm: Double): Double {
        return cm * 0.393700787
    }

    fun convertCmToFt(cm: Double): Double {
        return cm / 30.48f
    }

    fun convertCmToFtStringIfNeed(cm: Double, isKmSetting: Boolean): String {
        return if (isKmSetting) {
            formatDoubleToString(cm, 0)
        } else {
            formatInchToFeetString(convertCmToInch(cm))
        }
    }

    fun convertFtToCm(ft: Int): Double {
        return (ft * 30.48f).toDouble()
    }

    fun convertInchToCm(inch: Double): Double {
        return inch / 0.393700787
    }

    fun convertInchToFeetPair(inchRawValue: Double): Pair<Int, Int> {
        val valueFt = convertInchToFeet(inchRawValue.roundToInt().toDouble())
        val feet = valueFt.toInt()
        val inch = convertFeetToInch(valueFt - feet).roundToInt()
        return Pair(feet, inch)
    }

    fun convertMetToFeet(met: Double, isKm: Boolean): Double {
        return if (isKm) met else met * FEET_CONST
    }

    fun convertMileToKm(mile: Double): Double {
        return mile / KM_MILE_CONST
    }

    fun formatDoubleToString(value: Double): String {
        val df = DecimalFormat("#,##0.#")
        df.decimalFormatSymbols = DecimalFormatSymbols(Locale.getDefault())
        return df.format(value)
    }

    fun formatInchToFeetString(currentValue: Double): String {
        val feetPair = convertInchToFeetPair(currentValue)
        return feetPair.first.toString() + "\'" + feetPair.second + "\""
    }

    fun formatCmToFeetStringEmperic(cm: Double): String {
        val valueInch = convertCmToInch(cm)
        return formatInchToFeetString(valueInch)
    }

    fun convertTemp(tempValue: Double, isCelsius: Boolean): Double {
        return if (isCelsius) {
            tempValue
        } else tempValue * 9 / 5 + 32
    }

    fun convertFeetToMile(feet: Double): Double {
        return feet * FEET_TO_MILES_CONST
    }

    fun convertKilometerOrMileToMeter(value: Double, isKm: Boolean): Double {
        return if (isKm) {
            convertKilometersToMeters(value)
        } else convertMileToMeter(value)
    }

    fun convertCmOrInchToCm(value: Double, isKm: Boolean): Double {
        return if (isKm) {
            value
        } else convertInchToCm(value)
    }

    fun roundOffDecimal(number: Double): String {
//        val numberString  = number.toString().replace(",",".")
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.CEILING
        return df.format(number)
    }

    fun levelBMIAdult(bmi: Double): Int {
        return BMILevelAdult.values().find {
            bmi >= it.value.first && bmi < it.value.second
        }?.index?: 0
    }

    fun levelBMChild(bmi: Double): Int {
        return BMILevelChild.values().find {
            bmi >= it.value.first && bmi < it.value.second
        }?.index?: 0
    }
}