package com.example.stepscounter.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import com.example.stepscounter.data.local.entity.DayEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DayDao {

    @Query("SELECT * FROM day ORDER BY date ASC LIMIT 1")
    suspend fun getFirstDay(): DayEntity?

    @Query("SELECT * FROM day WHERE date >= :startDate AND date <= :endDate")
    fun getDay(startDate: Long, endDate: Long): Flow<DayEntity>

    @Query("SELECT * FROM day WHERE date >= :startDate AND date <= :endDate")
    suspend fun getDays(startDate: Long, endDate: Long): DayEntity?

    @Upsert
    suspend fun upsertDay(day: DayEntity)

    @Update(entity = DayEntity::class)
    suspend fun updateDaySettings(day: DayEntity)
}