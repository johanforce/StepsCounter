package com.example.stepscounter.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.stepscounter.presentation.core.*

@Entity
data class ProfileUserEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,
    @ColumnInfo(name = "firstname")
    val firstname: String = "",
    @ColumnInfo(name = "lastname")
    val lastname: String = "",
    @ColumnInfo(name = "gender")
    val gender: Int = GenderEnum.MALE.index,
    @ColumnInfo(name = "birthday")
    val birthday: Long = System.currentTimeMillis(),
    @ColumnInfo(name = "age")
    val age: Int = 0,
    @ColumnInfo(name = "weight")
    val weight: Double = 0.0,
    @ColumnInfo(name = "height")
    val height: Double = 0.0,
    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    var avatar: ByteArray? = null,
    @ColumnInfo(name = "avatarUrl")
    var avatarUrl: String = "",
    @ColumnInfo(name = "bio")
    val bio: String = "",
    @ColumnInfo(name = "unit")
    val unit: Int = UnitEnum.METRIC.index,
    @ColumnInfo(name = "national")
    val national: String = "vn",
    @ColumnInfo(name = "goal")
    val goal: Int = GoalEnum.MAINTAIN_WEIGHT.value,
    @ColumnInfo(name = "activity_level")
    val activityLevel: Int = ActivityLevelEnum.MODERATELY.value,
    @ColumnInfo(name = "theme_mode")
    val themeMode: Int = ThemeEnum.LIGHT.index
)
