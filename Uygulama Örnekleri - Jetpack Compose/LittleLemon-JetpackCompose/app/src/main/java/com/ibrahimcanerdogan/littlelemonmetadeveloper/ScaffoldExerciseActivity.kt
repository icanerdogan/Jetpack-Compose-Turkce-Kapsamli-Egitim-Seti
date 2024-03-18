package com.ibrahimcanerdogan.littlelemonmetadeveloper

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable

class ScaffoldExerciseActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScaffoldHomeScreen()
        }
    }
}

@Composable
fun ScaffoldHomeScreen() {
    Scaffold(
        topBar = { ScaffoldTopAppBar() }
    ) {
        Column {
            MainComponent()
        }
    }
}