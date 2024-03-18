package com.ibrahimcanerdogan.metajetpackcomposecourse.event

import android.widget.Toast
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ibrahimcanerdogan.metajetpackcomposecourse.R

@Composable
fun UpperPanel() {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .background(Color.Green)
            .padding(start = 12.dp, end = 12.dp, top = 16.dp, bottom = 16.dp)
    ) {
        Text(
            text = "Little Lemon",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
        )
        Text(
            text = "Chicago",
            fontSize = 24.sp,
            color = Color.White,
        )
        Row(
            modifier = Modifier.padding(top = 18.dp),
        ) {

            Text(
                text = stringResource(id = R.string.description_short),
                modifier = Modifier.padding(bottom = 28.dp).fillMaxWidth(0.6f),
                color = Color.White,
                fontSize = 18.sp
            )
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                modifier = Modifier.height(200.dp).clip(RoundedCornerShape(20.dp)),
                contentDescription = "Upper Panel Image"
            )
        }

        Button(
            onClick = {
                Toast.makeText(context, "Order Successfully!", Toast.LENGTH_SHORT).show()
            },
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.White)
        ) {
            Text(text = stringResource(R.string.order))
        }
    }
}