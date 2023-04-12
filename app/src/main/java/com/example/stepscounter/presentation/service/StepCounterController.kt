package com.example.stepscounter.presentation.service

import android.content.Intent
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.example.stepscounter.di.App
import com.example.stepscounter.domain.usecase.StepsInDayUseCase
import com.example.stepscounter.domain.usecase.StepsInDaysUseCase
import com.example.stepscounter.domain.usecase.UpdateStepsUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import java.time.LocalDate


class StepCounterController : KoinComponent {
    private val stepsInDayUseCase: StepsInDaysUseCase by inject()
    private val updateStepsUseCase: UpdateStepsUseCase by inject()

    var previousStepCount: Int = 0
    var currentSteps: Int = 0

    fun onStepCountChanged(newStepCount: Int, eventDate: LocalDate,  updateSteps: (steps: Int) -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            val dayData = stepsInDayUseCase.invoke(eventDate)


            if (previousStepCount > 0) {
                currentSteps= dayData.steps + (newStepCount - previousStepCount)
                dayData.steps = currentSteps
                updateStepsUseCase.invoke(dayData)
            }
            previousStepCount = newStepCount
            updateSteps(currentSteps)
        }
    }
}
