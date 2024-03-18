package com.ibrahimcanerdogan.metajetpackcomposecourse.event

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class LittleLemonEventHandling : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UpperPanel()
        }
    }
}
