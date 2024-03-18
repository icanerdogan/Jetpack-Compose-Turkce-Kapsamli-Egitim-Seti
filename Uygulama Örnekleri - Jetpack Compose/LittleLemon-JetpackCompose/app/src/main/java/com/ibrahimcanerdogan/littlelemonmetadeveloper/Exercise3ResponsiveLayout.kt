package com.ibrahimcanerdogan.littlelemonmetadeveloper

/*
import android.content.res.Configuration.ORIENTATION_LANDSCAPE
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.ibrahimcanerdogan.littlelemonmetadeveloper.R

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val materialBlue700 = Color(0xFF1976D2)
            val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Open))
            Scaffold(
                scaffoldState = scaffoldState,
                topBar = {
                    TopAppBar(
                        title = { Text(resources.getString(R.string.app_name)) },
                        contentColor = Color.White,
                        backgroundColor = materialBlue700
                    )
                },
                content = { paddingValues ->
                    MenuContent(paddingValues = paddingValues)
                }
            )
        }
    }
}

@Composable
fun MenuContent(paddingValues: PaddingValues) {
    Surf   ace(modifier = Modifier.padding(paddingValues)) {
        val menuPadding = 8.dp
        // region Thomas, the code the student needs to add starts here.
        val configuration = LocalConfiguration.current
        when (configuration.orientation) {
            ORIENTATION_LANDSCAPE -> {
                Column {
                    Row(modifier = Modifier.weight(0.5f)) {
                        Text(
                            "Appetizers",
                            modifier = Modifier
                                .weight(0.25f)
                                .fillMaxHeight()
                                .background(Purple80)
                                .padding(menuPadding)
                        )
                        Text(
                            "Salads",
                            modifier = Modifier
                                .weight(0.25f)
                                .fillMaxHeight()
                                .padding(menuPadding)
                        )
                    }
                    Row(modifier = Modifier.weight(0.5f)) {
                        Text(
                            "Drinks",
                            modifier = Modifier
                                .weight(0.25f)
                                .fillMaxHeight()
                                .background(Pink80)
                                .padding(menuPadding)
                        )
                        Text(
                            "Mains",
                            modifier = Modifier
                                .weight(0.25f)
                                .fillMaxHeight()
                                .background(PurpleGrey80)
                                .padding(menuPadding)
                        )
                    }
                }
            }

            else -> {
                Column {
                    Text(
                        "Appetizers",
                        modifier = Modifier
                            .weight(0.25f)
                            .background(Purple80)
                            .padding(menuPadding)
                            .fillMaxWidth()
                    )
                    Text(
                        "Salads",
                        modifier = Modifier
                            .weight(0.25f)
                            .padding(menuPadding)
                            .fillMaxWidth()
                    )
                    Text(
                        "Drinks",
                        modifier = Modifier
                            .weight(0.25f)
                            .background(Pink80)
                            .padding(menuPadding)
                            .fillMaxWidth()
                    )
                    Text(
                        "Mains",
                        modifier = Modifier
                            .weight(0.25f)
                            .background(PurpleGrey80)
                            .padding(menuPadding)
                            .fillMaxWidth()
                    )
                }
            }
        }
        // endregion Thomas, this is where the code the student adds ends.
        // Below is the code as provided to the student:
        */
/*
                Column {
                    Text(
                        "Appetizers",
                        modifier = Modifier
                            .weight(0.25f)
                            .background(Purple80)
                            .padding(menuPadding)
                            .fillMaxWidth()
                    )
                    Text(
                        "Salads",
                        modifier = Modifier
                            .weight(0.25f)
                            .padding(menuPadding)
                            .fillMaxWidth()
                    )
                    Text(
                        "Drinks",
                        modifier = Modifier
                            .weight(0.25f)
                            .background(Pink80)
                            .padding(menuPadding)
                            .fillMaxWidth()
                    )
                    Text(
                        "Mains",
                        modifier = Modifier
                            .weight(0.25f)
                            .background(PurpleGrey80)
                            .padding(menuPadding)
                            .fillMaxWidth()
                    )
                }
         *//*

    }
}
*/
