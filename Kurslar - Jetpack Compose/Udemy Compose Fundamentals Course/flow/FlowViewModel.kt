package com.example.composefundamentals.flow

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class FlowViewModel : ViewModel() {

    val myFlow = flow<Int> {
        for (i in 1 until 100) {
            Log.i("MYTAG", "Produced $i")
            emit(i)
            delay(1000L)
        }
    }

    init {
        backPressureDemo()
    }

    private fun backPressureDemo() {
        val myFlow = flow<Int> {
            for (i in 1 until 100) {
                Log.i("MYTAG", "Produced $i")
                emit(i)
                delay(1000L)
            }
        }

        viewModelScope.launch {
            // buffer(): Buffers flow emissions via channel of a specified capacity and runs collector in a separate coroutine.
            // if you want to use buffer() call this: myFlow.buffer().collect

            // collectLatest {} : Last value emit in flows.
            // if you want to use collectLatest call this: myFlow.collectLatest
            myFlow
                .filter {
                    count -> count % 3 == 0
                }
                .map { it ->
                    showMessageForMap(it)
                }
                .collect {
                    //delay(2000L)
                    Log.i("MYTAG", "Consumed $it")
                }
        }
    }

    fun showMessageForMap(count: Int): String {
        return "Hello $count"
    }

}