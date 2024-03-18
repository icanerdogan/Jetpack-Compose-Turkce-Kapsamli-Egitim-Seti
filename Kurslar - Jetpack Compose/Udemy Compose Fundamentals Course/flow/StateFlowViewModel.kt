package com.example.composefundamentals.flow

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.StateFlow

class StateFlowViewModel(startingTotal : Int) : ViewModel() {
    // !! KOTLIN FLOWS HOW TO USE IN XML

/*    private val _flowTotal = MutableStateFlow<Int>(0)
    val flowTotal : StateFlow<Int> = _flowTotal

    private val _message = MutableSharedFlow<String>()
    val message : MutableSharedFlow<String> = _message


    init {
        _flowTotal.value = startingTotal
    }

    fun setTotal(input:Int){
        _flowTotal.value = (_flowTotal.value).plus(input)
        viewModelScope.launch {
            _message.emit("Total updated successfully!")
        }
    }*/
}