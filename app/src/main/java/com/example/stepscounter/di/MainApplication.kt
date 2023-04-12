package com.example.stepscounter.di

import android.annotation.SuppressLint
import android.app.Application
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.lifecycle.MutableLiveData
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import java.time.LocalDate

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        App.context = this
        App.application = this
        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(dataModule, repositoryModule, useCaseModule, viewModelModule)
        }
    }
}

@SuppressLint("StaticFieldLeak")
object App {
    lateinit var context: Context
    lateinit var application: MainApplication
}
