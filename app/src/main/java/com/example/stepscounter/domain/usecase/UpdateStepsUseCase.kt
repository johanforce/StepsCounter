package com.example.stepscounter.domain.usecase

import com.example.stepscounter.domain.model.DayModel
import com.example.stepscounter.domain.repository.DayRepository
import org.koin.core.component.inject

class UpdateStepsUseCase : NoResultBaseUseCase<DayModel>() {

    private val dayRepository: DayRepository by inject()

    override suspend fun invoke(input: DayModel) {
        return dayRepository.upsertDay(input)
    }
}
