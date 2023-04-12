package com.example.stepscounter.presentation.main

import android.content.Intent
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import com.example.stepscounter.databinding.ActivityMainBinding
import com.example.stepscounter.presentation.base.BaseActivity
import com.example.stepscounter.presentation.service.StepCounterService
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {
    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startStepCounterService()
    }

    override fun observeData() {
        super.observeData()

        lifecycleScope.launch {
            viewModel.stepsInday.collect {
                binding.tvData.text = it.toString()
            }
        }
    }

    private fun startStepCounterService() {
        val intent = Intent(this, StepCounterService::class.java)
        ContextCompat.startForegroundService(this, intent)
    }
}
