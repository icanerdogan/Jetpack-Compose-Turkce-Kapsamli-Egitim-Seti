package com.ibrahimcanerdogan.littlelemonmetadeveloper

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ibrahimcanerdogan.littlelemonmetadeveloper.ui.theme.LittleLemonMetaDeveloperTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LittleLemonMetaDeveloperTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color =  MaterialTheme.colorScheme.background
                ) {
                    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                        MainName(
                            restaurantName = stringResource(id = R.string.developer_name),
                            size = 20,
                            restaurantColor = Color(0xFFF4CE14)
                        )
                        MainName(
                            restaurantName = stringResource(id = R.string.app_name),
                            size = 20,
                            restaurantColor = Color(0xF004CE44)
                        )
                        Row {
                            Button(
                                onClick = { /*TODO*/ },
                                border = BorderStroke(1.dp, Color.Red),
                                shape = RoundedCornerShape(10.dp),
                                colors = ButtonDefaults
                                    .buttonColors(contentColor = Color.Gray, containerColor = Color.Cyan)
                            ) {
                                Text(text = stringResource(id = R.string.order))
                            }
                            Image(
                                painter = painterResource(id = R.drawable.example_icon),
                                contentDescription = ""
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MainName(restaurantName: String, size: Int, restaurantColor: Color) {
    Text(
        text = restaurantName,
        fontSize = size.sp,
        color = restaurantColor
    )
}

@Preview(showBackground = true)
@Composable
fun MainNamePreview() {
    MainName(
        restaurantName = stringResource(id = R.string.developer_name),
        size = 32,
        restaurantColor = Color(0xFFF4CE14)
    )
}


