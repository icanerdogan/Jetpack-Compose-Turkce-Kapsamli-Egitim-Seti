package com.example.composefundamentals.effecthandler

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composefundamentals.ui.theme.ComposeFundamentalsTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class SideEffectsDemo : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeFundamentalsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    context: Context = LocalContext.current
) {
    var round by remember { mutableStateOf(1) }
    var total by remember { mutableStateOf(0.0) }
    var input by remember { mutableStateOf("") }

    //     LaunchedEffect(key1 = round) {
    //        Toast.makeText(context, "Starting count Round Value : $round", Toast.LENGTH_SHORT).show()
    //    }

    val scaffoldState : ScaffoldState = rememberScaffoldState()
    val coroutineScope : CoroutineScope = rememberCoroutineScope()

    Scaffold(scaffoldState = scaffoldState,
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(50.dp),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                // Total Text
                Text(
                    modifier = modifier.fillMaxWidth(),
                    text = "Total is ${total.toString()}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    color = Color.DarkGray
                )

                // Input Text
                OutlinedTextField(
                    modifier = modifier.fillMaxWidth(),
                    placeholder = { Text("Enter value here...") },
                    value = input,
                    onValueChange = { input = it },
                    textStyle = TextStyle(
                        color = Color.LightGray,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    label = { Text(text = "New Count") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )

                // Button
                Button(
                    modifier = modifier.fillMaxWidth(),
                    onClick = {
                        total += input.toDouble()
                        // Launched Effect
                        coroutineScope.launch {
                            scaffoldState.snackbarHostState.showSnackbar(
                                message = "Count updated.. Round Value : $round",
                                duration = SnackbarDuration.Short
                            )
                        }
                        if (total > 300) {
                            total = 0.0
                            input = ""
                            round++
                        }
                    }
                ) {
                    Text(
                        text = "Count",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

            }
        }

    )

}