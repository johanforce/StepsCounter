package com.example.stepscounter.domain.model

import com.example.stepscounter.data.local.entity.DayEntity
import java.time.LocalDate
import java.time.ZoneId
import java.util.*

data class DayModel(

    val date: LocalDate,

    var steps: Int = 0,

    val goal: Int = 0,

    val height: Int = 188,

    val weight: Int = 70,

    val stepLength: Int = 72,

    val pace: Double = 1.0
) {

    val distanceTravelled
        get() = run {
            val distanceCentimeters = steps * stepLength
            distanceCentimeters.toDouble() / 100_000
        }

    val calorieBurned
        get() = run {
            val modifier = height / 182.0 + weight / 70.0 - 1
            0.04 * steps * pace * modifier
        }

    val carbonDioxideSaved
        get() = run {
            steps * 0.1925 / 1000.0
        }

    fun convertModelToEntity(): DayEntity {
        val dates = Date.from(this.date.atStartOfDay(ZoneId.systemDefault()).toInstant())
        return DayEntity(
            date = dates.time,
            steps = this.steps,
            goal = this.goal,
            height = this.height,
            weight = this.weight,
            stepLength = this.stepLength,
            pace = this.pace,
        )
    }
}