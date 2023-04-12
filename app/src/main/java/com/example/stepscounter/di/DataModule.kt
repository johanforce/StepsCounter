package com.example.stepscounter.di

import com.example.stepscounter.data.local.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {
    single {
        AppDatabase.build(androidContext())
    }
}
