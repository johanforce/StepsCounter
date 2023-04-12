package com.example.stepscounter.domain.usecase

import com.example.stepscounter.domain.model.DayModel
import com.example.stepscounter.domain.repository.DayRepository
import kotlinx.coroutines.flow.Flow
import org.koin.core.component.inject
import java.time.LocalDate

class StepsInDaysUseCase : BaseUseCases<DayModel?, LocalDate>() {

    private val dayRepository: DayRepository by inject()

    override suspend fun invoke(input: LocalDate): DayModel {
        return dayRepository.getDays(input)?: DayModel(LocalDate.now())
    }
}
