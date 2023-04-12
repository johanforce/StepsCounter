package com.example.stepscounter.domain.repository

import com.example.stepscounter.domain.model.DayModel
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

interface DayRepository {

    suspend fun getFirstDay(): DayModel?

    fun getDay(date: LocalDate): Flow<DayModel?>

    suspend fun getDays(date: LocalDate): DayModel?

    suspend fun upsertDay(day: DayModel)
}