package com.example.composefundamentals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composefundamentals.ui.theme.ComposeFundamentalsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeFundamentalsTheme {
                Row (
                    modifier = Modifier
                        .background(color = Color.LightGray)
                        .fillMaxSize(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.Top
                ) {
                    Greeting("Ibrahim")
                    Greeting("Can")
                    Greeting("Erdogan")
                }

                /*
                Column(
                    modifier = Modifier
                        .background(color = Color.LightGray)
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Greeting("Ibrahim")
                    Greeting("Can")
                    Greeting("Erdogan")
                }
                */

            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "$name!",
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Red,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .background(color = Color.Yellow)
            .border(2.dp, color = Color.Green)
            .padding(10.dp)
            .fillMaxHeight(0.1f)
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeFundamentalsTheme {
        Greeting("Android")
    }
}