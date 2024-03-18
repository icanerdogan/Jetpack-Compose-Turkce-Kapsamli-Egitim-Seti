package com.example.composefundamentals

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

class ButtonActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                ButtonDemo()
            }
        }
    }
}

@Composable
fun ButtonDemo() {
    val context = LocalContext.current
    Button(
        onClick = { Toast.makeText(context, "Clicked on Button1!", Toast.LENGTH_SHORT).show()}
    ){
        Text("Button1!")
    }

    Button(
        onClick = { Toast.makeText(context, "Clicked on Button2!", Toast.LENGTH_SHORT).show() },
        enabled = false
    ){
        Text("Button2!")
    }
    TextButton(
        onClick = { Toast.makeText(context, "Clicked on Text Button!", Toast.LENGTH_SHORT).show() }
    ){
        Text("Text Button!")
    }
    OutlinedButton(
        onClick = { Toast.makeText(context, "Clicked on Outlined Button!", Toast.LENGTH_SHORT).show() }
    ){
        Text("Clicked Button!")
    }
    IconButton(
        onClick = { Toast.makeText(context, "Clicked on Icon Button!", Toast.LENGTH_SHORT).show() }
    ){
        Icon(
            Icons.Filled.Refresh,
            contentDescription = "Refresh Button!",
            tint = Color.DarkGray,
            modifier = Modifier
                .size(70.dp)
        )
    }

    Button(
        onClick = { Toast.makeText(context, "Clicked on Cut Corner Shape Button!", Toast.LENGTH_SHORT).show() },
        shape = CutCornerShape(25.dp),
        contentPadding = PaddingValues(16.dp),
        border = BorderStroke(10.dp, Color.Black),
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = Color.DarkGray,
            contentColor = Color.White
        )
    ){
        Text(
            "Button3!",
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .padding(5.dp)
        )
    }

    Button(
        onClick = { Toast.makeText(context, "Clicked on Circle Shape Button!", Toast.LENGTH_SHORT).show() },
        shape = CircleShape,
        contentPadding = PaddingValues(16.dp),
        border = BorderStroke(10.dp, Color.Black),
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = Color.DarkGray,
            contentColor = Color.White
        )
    ){
        Text(
            "Button4!",
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .padding(5.dp)
        )
    }
}
