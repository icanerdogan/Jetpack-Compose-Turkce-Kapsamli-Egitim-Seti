package com.ibrahimcanerdogan.metajetpackcomposecourse.state

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class StateExample : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppScreen()
        }
    }
}

@Composable
fun AppScreen() {
    var count by remember { mutableIntStateOf(0) }
    ItemOrder(count, { count++ }, { count-- })
}
@Composable
fun ItemOrder(count: Int, onIncrement: () -> Unit, onDecrement: () -> Unit) {

    /* Both difference between screen rotate action!*/
    // var count by remember { mutableIntStateOf(0) }
    /* var saveableCount by rememberSaveable {
        mutableIntStateOf(0)
    }*/

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            shape = RoundedCornerShape(20.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 40.dp)
        ) {
            Text(
                text = "Margarita Pizza",
                fontWeight = FontWeight.W700,
                fontSize = 30.sp,
                modifier = Modifier.padding(start = 20.dp, top = 20.dp)
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextButton(onClick = { onDecrement() }) {
                    Text(text = "-", Modifier.size(42.dp), fontSize = 32.sp)
                }
                Text(text = count.toString(), Modifier.size(42.dp), fontSize = 32.sp)
                TextButton(onClick = { onIncrement() }) {
                    Text(text = "+", Modifier.size(42.dp), fontSize = 32.sp)
                }
            }
            Button(onClick = { /*TODO*/ },
                Modifier
                    .fillMaxWidth()
                    .padding(20.dp)) {
                Text(text = "Add")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppScreenPreview() {
    AppScreen()
}