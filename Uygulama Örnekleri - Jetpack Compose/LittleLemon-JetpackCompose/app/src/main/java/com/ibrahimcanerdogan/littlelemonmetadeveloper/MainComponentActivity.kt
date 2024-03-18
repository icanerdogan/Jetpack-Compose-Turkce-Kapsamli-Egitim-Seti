package com.ibrahimcanerdogan.littlelemonmetadeveloper

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ibrahimcanerdogan.littlelemonmetadeveloper.ui.theme.LittleLemonMetaDeveloperTheme

class MainComponentActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LittleLemonMetaDeveloperTheme {
                MainComponent()
            }
        }
    }
}

@Composable
fun MainComponent() {
    val context = LocalContext.current

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF0921CC))
    ) {
        Text(
            text = "Little Lemon",
            fontSize = 32.sp,
            color = Color(0xFFF4CE14),
            modifier = Modifier.padding(start = 10.dp, top = 50.dp)
        )
        Text(
            text = "İbrahim Can Erdoğan",
            fontSize = 24.sp,
            color = Color(0xFFFFFFFF),
            modifier = Modifier.padding(start = 10.dp)
        )

        Button(
            onClick = { Toast.makeText(context, "Toast Message!", Toast.LENGTH_SHORT).show() },
            border = BorderStroke(1.dp, Color.Yellow),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = stringResource(id = R.string.order))
        }

        Row(
            Modifier.height(200.dp).padding(10.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.description_short),
                modifier = Modifier.width(200.dp),
                color = Color.White,
                fontSize = 10.sp
            )
            Image(
                painter = painterResource(R.drawable.icon_little_lemon),
                modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(50.dp)),
                contentDescription = "",
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainComponentPreview() {
    MainComponent()
}