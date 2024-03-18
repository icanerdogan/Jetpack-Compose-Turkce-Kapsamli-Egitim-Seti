package com.example.composefundamentals

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composefundamentals.ui.theme.ComposeFundamentalsTheme

class ComposeStateDemo : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = viewModel<ViewModelDemo>()
            ComposeFundamentalsTheme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // rememberSaveable: Save data Android recreates the activity. Shouldn't be using large amount and complex data.
                    //var count by rememberSaveable { mutableStateOf(0) }
                    //MyButtonUnidirectional(count) { count = it + 1 }

                    // with viewmodel.
                    val count = viewModel.count
                    MyButtonUnidirectional(count) { viewModel.increaseCount() }

                }
            }
        }
    }
}

// Change DATA and UI at same time.
val count = mutableStateOf(0)
@Preview(name = "MyButton")
@Composable
fun MyButton() {
    val context = LocalContext.current
    // remember: compose runtime to remember current value of the state. Add ".value" for variables value.
    // val count = remember { mutableStateOf(0) }
    // MutableState<Int> to Int.
    var count by remember { mutableStateOf(0) }
    Button(
        onClick = {
            count += 1
            Toast.makeText(context, "Count is : $count!", Toast.LENGTH_SHORT).show()
        },
        contentPadding = PaddingValues(16.dp),
        border = BorderStroke(2.dp, Color.Cyan),
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = Color.DarkGray,
            contentColor = Color.White
        )
    ){
        Text(
            "Count is : $count",
            style = MaterialTheme.typography.h3,
            modifier = Modifier
                .padding(5.dp)
        )
    }
}

@Composable
fun MyButtonUnidirectional(currentCount: Int, updateCount: (Int) -> Unit) {
    Button(
        onClick = { updateCount(currentCount) },
        contentPadding = PaddingValues(16.dp),
        border = BorderStroke(2.dp, Color.Cyan),
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = Color.DarkGray,
            contentColor = Color.White
        )
    ){
        Text(
            "Count is : $currentCount",
            style = MaterialTheme.typography.h3,
            modifier = Modifier
                .padding(5.dp)
        )
    }
}
