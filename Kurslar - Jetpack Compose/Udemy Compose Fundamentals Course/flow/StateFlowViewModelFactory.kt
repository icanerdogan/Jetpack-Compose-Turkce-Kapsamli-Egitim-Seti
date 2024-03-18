package com.example.composefundamentals.flow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class StateFlowViewModelFactory(private val startingTotal : Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T = StateFlowViewModel(startingTotal) as T
}