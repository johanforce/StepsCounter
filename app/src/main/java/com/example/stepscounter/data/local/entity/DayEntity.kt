package com.example.stepscounter.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.stepscounter.domain.model.DayModel
import com.jarvis.domain.mapper.MapAbleToModel
import java.time.LocalDate
import java.time.ZoneId
import java.util.Date

@Entity(tableName = "day")
data class DayEntity(

    @PrimaryKey
    val date: Long,
    @ColumnInfo(name = "steps")
    val steps: Int = 0,
    @ColumnInfo(name = "goal")
    val goal: Int,
    @ColumnInfo(name = "height")
    val height: Int = 188,
    @ColumnInfo(name = "weight")
    val weight: Int = 70,
    @ColumnInfo(name = "step_length")
    val stepLength: Int = 72,
    @ColumnInfo(name = "pace")
    val pace: Double = 1.0
) : MapAbleToModel<DayModel> {
    override fun toModel(): DayModel {
        return DayModel(
            date = Date(date).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
            steps = steps,
            goal = goal,
            height = height,
            weight = weight,
            stepLength = stepLength,
            pace = pace
        )
    }

}