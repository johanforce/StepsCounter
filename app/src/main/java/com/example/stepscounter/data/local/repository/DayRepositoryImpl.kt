package com.example.stepscounter.data.local.repository

import com.example.stepscounter.data.local.AppDatabase
import com.example.stepscounter.data.local.dao.DayDao
import com.example.stepscounter.domain.model.DayModel
import com.example.stepscounter.domain.repository.DayRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.time.LocalDate
import java.time.ZoneId
import java.util.*

class DayRepositoryImpl(
    database: AppDatabase
) : DayRepository {
    private val dao = database.dayDao()

    override suspend fun getFirstDay(): DayModel? {
        return kotlin.runCatching {
            dao.getFirstDay()?.toModel()
        }.getOrNull()
    }

    override fun getDay(date: LocalDate): Flow<DayModel?> {
        val cal = Calendar.getInstance()
        val dates = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant())
        cal.time = dates
        cal.set(Calendar.HOUR_OF_DAY, 0)
        cal.set(Calendar.MINUTE, 0)
        cal.set(Calendar.SECOND, 0)
        cal.set(Calendar.MILLISECOND, 0)
        val startDate = cal.timeInMillis

        cal.set(Calendar.HOUR_OF_DAY, 23)
        cal.set(Calendar.MINUTE, 59)
        cal.set(Calendar.SECOND, 59)
        cal.set(Calendar.MILLISECOND, 999)
        val endDate = cal.timeInMillis

       return dao.getDay(startDate, endDate).map { it?.toModel()}
    }

    override suspend fun getDays(date: LocalDate): DayModel? {
        val cal = Calendar.getInstance()
        val dates = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant())
        cal.time = dates
        cal.set(Calendar.HOUR_OF_DAY, 0)
        cal.set(Calendar.MINUTE, 0)
        cal.set(Calendar.SECOND, 0)
        cal.set(Calendar.MILLISECOND, 0)
        val startDate = cal.timeInMillis

        cal.set(Calendar.HOUR_OF_DAY, 23)
        cal.set(Calendar.MINUTE, 59)
        cal.set(Calendar.SECOND, 59)
        cal.set(Calendar.MILLISECOND, 999)
        val endDate = cal.timeInMillis

        return dao.getDays(startDate, endDate)?.toModel()
    }

    override suspend fun upsertDay(day: DayModel) {
        dao.upsertDay(day.convertModelToEntity())
    }
}