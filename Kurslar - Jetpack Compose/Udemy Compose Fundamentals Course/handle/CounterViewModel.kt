package com.example.composefundamentals.handle

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class CounterViewModel : ViewModel() {

    private var total = 0.0

    private val _screenState = mutableStateOf(
        MainScreenState(inputValue = "", displayingResult = "Total is 0.0")
    )

    val screenState : State<MainScreenState> = _screenState

    private val _uiEventFlow = MutableSharedFlow<UIEvent>()
    val uiEvent = _uiEventFlow.asSharedFlow()

    private fun addTotal() {
        total += _screenState.value.inputValue.toDouble()
        // Only change displayResult
        _screenState.value = _screenState.value.copy(
            displayingResult = "Total is $total",
            isCountVisible = false
        )
    }

    private fun resetTotal() {
        total = 0.0
        _screenState.value = _screenState.value.copy(
            displayingResult = "Total is $total",
            inputValue = "",
            isCountVisible = false
        )
    }

    fun onEvent(event : CounterEvent) {
        when(event) {
            is CounterEvent.ValueEntered -> {
                _screenState.value = _screenState.value.copy(
                    inputValue = event.value,
                    isCountVisible = true
                )
            }
            is CounterEvent.CountButtonClicked -> {
                addTotal()
                viewModelScope.launch {
                    _uiEventFlow.emit(
                        UIEvent.ShowMessage(message = "Value Added Successfully...")
                    )
                }
            }
            is CounterEvent.ResetButtonClicked -> {
                resetTotal()
                viewModelScope.launch {
                    _uiEventFlow.emit(
                        UIEvent.ShowMessage(message = "Value Reset Successfully...")
                    )
                }
            }
        }
    }
}