package com.ibrahimcanerdogan.metajetpackcomposecourse.modifier

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ibrahimcanerdogan.metajetpackcomposecourse.R
import com.ibrahimcanerdogan.metajetpackcomposecourse.ui.theme.MetaJetpackComposeCourseTheme

class LittleLemonOrder: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContent {
            MetaJetpackComposeCourseTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    OrderScreen()
                }
            }
        }
    }
}

@Composable
fun OrderScreen() {
    Column(
        Modifier
            .fillMaxWidth()
            .background(Color.Magenta),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "Little Lemon",
            fontSize = 32.sp,
            color = Color.Green,
            modifier = Modifier.padding(start = 20.dp, top = 20.dp)
        )
        Text(
            text = "Chicago",
            fontSize = 32.sp,
            color = Color.Black,
            modifier = Modifier.padding(start = 20.dp)
        )
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {

            Text(
                text = stringResource(id = R.string.description_short),
                modifier = Modifier.width(200.dp),
                color = Color.White,
                fontSize = 21.sp
            )
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                modifier = Modifier.height(200.dp).clip(RoundedCornerShape(20.dp)),
                contentDescription = ""
            )
        }

        Button(
            onClick = { /*TODO*/ },
            border = BorderStroke(1.dp, Color.Red),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
        ) {
            Text(text = stringResource(R.string.order))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OrderScreenPreview() {
    OrderScreen()
}