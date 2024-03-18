package com.example.composefundamentals

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ViewModelDemo : ViewModel() {

    var count by mutableStateOf(0)

    fun increaseCount() {
        count++
    }
}