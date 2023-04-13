package com.example.stepscounter.presentation.main

import androidx.lifecycle.viewModelScope
import com.example.stepscounter.domain.model.DayModel
import com.example.stepscounter.domain.usecase.StepsInDayUseCase
import com.example.stepscounter.presentation.base.BaseViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import org.koin.core.component.inject
import java.time.LocalDate

class MainViewModel : BaseViewModel() {
    private val stepsInDayUseCase: StepsInDayUseCase by inject()

    private val _stepsInDay = MutableStateFlow(DayModel(date = LocalDate.now()))
    val stepsInday: StateFlow<DayModel> = _stepsInDay.asStateFlow()

    init {
        stepsInDayUseCase.invoke(LocalDate.now()).onEach { data ->
            _stepsInDay.value = data
        }.launchIn(viewModelScope)
    }
}
