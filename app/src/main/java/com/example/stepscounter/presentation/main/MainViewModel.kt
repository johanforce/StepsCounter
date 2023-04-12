package com.example.stepscounter.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.stepscounter.domain.model.DayModel
import com.example.stepscounter.domain.usecase.StepsInDayUseCase
import com.example.stepscounter.domain.usecase.StepsInDaysUseCase
import com.example.stepscounter.presentation.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.component.inject
import java.time.LocalDate

class MainViewModel : BaseViewModel() {
    private val stepsInDayUseCase: StepsInDayUseCase by inject()
    val stepsInday: Flow<DayModel?> =  stepsInDayUseCase.invoke(LocalDate.now())
}
