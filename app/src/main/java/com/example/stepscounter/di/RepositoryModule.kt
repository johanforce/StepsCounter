package com.example.stepscounter.di

import com.example.stepscounter.data.local.repository.DayRepositoryImpl
import com.example.stepscounter.domain.repository.DayRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<DayRepository> {
        DayRepositoryImpl(database = get())
    }
}
