package com.example.stepscounter.domain.usecase

import com.example.stepscounter.domain.model.DayModel
import com.example.stepscounter.domain.repository.DayRepository
import kotlinx.coroutines.flow.Flow
import org.koin.core.component.inject
import java.time.LocalDate

class StepsInDayUseCase : BaseUseCase<Flow<DayModel?>, LocalDate>() {

    private val dayRepository: DayRepository by inject()

    override fun invoke(input: LocalDate): Flow<DayModel?> {
        return dayRepository.getDay(input)
    }
}
