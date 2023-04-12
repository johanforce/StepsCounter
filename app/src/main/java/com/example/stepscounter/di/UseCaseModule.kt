package com.example.stepscounter.di

import com.example.stepscounter.domain.usecase.StepsInDayUseCase
import com.example.stepscounter.domain.usecase.StepsInDaysUseCase
import com.example.stepscounter.domain.usecase.UpdateStepsUseCase
import org.koin.dsl.module

val useCaseModule = module {

    // Home
    single { StepsInDayUseCase() }
    single { UpdateStepsUseCase() }
    single { StepsInDaysUseCase() }
}
