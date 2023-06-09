package com.example.stepscounter.presentation.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import org.koin.core.component.KoinComponent

abstract class BaseViewModel : ViewModel(), KoinComponent {

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        throwable.printStackTrace()
    }

    protected val scope = viewModelScope.plus(exceptionHandler)

    /**
     * @param scope coroutine scope to execute task
     * @param onError the callback run when had error
     * @param onExecute the action to execute task
     * */
    protected fun <T> executeTask(
        scope: CoroutineScope = this.scope,
        onError: ((Exception) -> Unit)? = null,
        onExecute: suspend () -> T,
    ) {
        scope.launch(Dispatchers.Main) {
            try {
                onExecute()
            } catch (e: Exception) {
                onError?.invoke(e) ?: throw e
            }
        }
    }
}
