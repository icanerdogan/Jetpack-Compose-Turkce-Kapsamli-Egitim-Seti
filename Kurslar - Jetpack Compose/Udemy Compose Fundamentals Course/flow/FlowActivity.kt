package com.example.composefundamentals.flow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composefundamentals.ui.theme.ComposeFundamentalsTheme

class FlowActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // https://kotlinlang.org/api/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/-flow/
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = viewModel<FlowViewModel>()
            // collectAsState -> cold flow
            val currentValue = viewModel.myFlow.collectAsState(initial = 1).value
            ComposeFundamentalsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Text(
                        text = "Current Value: $currentValue",
                        fontSize = 25.sp
                    )
                }
            }
        }
    }
}
