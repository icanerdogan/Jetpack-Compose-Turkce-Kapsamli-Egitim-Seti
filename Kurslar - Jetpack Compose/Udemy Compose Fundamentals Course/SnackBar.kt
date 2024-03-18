package com.example.composefundamentals

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.example.composefundamentals.ui.theme.ComposeFundamentalsTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class SnackBar : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeFundamentalsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DisplaySnackBar()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DisplaySnackBar() {
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val coroutineScope: CoroutineScope = rememberCoroutineScope()

    Scaffold(scaffoldState = scaffoldState) {
        Button(onClick = {
            coroutineScope.launch {
                val snackBarResult = scaffoldState.snackbarHostState.showSnackbar(
                    message = "This is the snackbar message.",
                    actionLabel = "Undo",
                    duration = SnackbarDuration.Short
                )

                when(snackBarResult) {
                    SnackbarResult.ActionPerformed -> Log.i("TAG", "Action Label Clicked!")
                    SnackbarResult.Dismissed -> Log.i("TAG", "Action Label Dismissed!")
                }
            }
        }) {
            Text(text = "Display Snack Bar")
        }
    }
}

