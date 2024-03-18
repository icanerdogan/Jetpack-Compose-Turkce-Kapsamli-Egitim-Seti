package com.example.composefundamentals

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.composefundamentals.compose.TvShowListItem
import com.example.composefundamentals.data.TvShowList
import com.example.composefundamentals.model.TvShow

class LazyColumn : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // ScrollableColumnDemo()
            // LazyColumnDemo()
            /*LazyColumnDemo2 {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }*/
            DisplayTvShows {
                //Toast.makeText(this, it.name, Toast.LENGTH_SHORT).show()
                startActivity(InfoActivity.intent(this, it))
            }
        }
    }
}

// To make column scrollable.
// 1. Get an instance of ScrollState
// 2. Add VerticalScroll modifier.
@Composable
fun ScrollableColumnDemo() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .verticalScroll(scrollState)
    ) {
        for (i in 1..1000) {
            Text(
                "User Name $i",
                style = MaterialTheme.typography.h3,
                modifier = Modifier
                    .padding(10.dp)
            )
            Divider(color = Color.Black, thickness = 5.dp)
        }
    }
}
// If you want to the best performance recyclerview. Should be used a LAZY COLUMN in Compose

@Composable
fun LazyColumnDemo() {
    LazyColumn {
        items(100) {
            Text(
                "User Name $it",
                style = MaterialTheme.typography.h3,
                modifier = Modifier
                    .padding(10.dp)
            )
            Divider(color = Color.Black, thickness = 5.dp)
        }
    }
}

@Composable
fun LazyColumnDemo2(selectedItem : (String) -> (Unit)) {
    LazyColumn {
        items(100) {
            Text(
                "User Name $it",
                style = MaterialTheme.typography.h3,
                modifier = Modifier
                    .padding(10.dp)
                    .clickable { selectedItem("$it seleceted.") }
            )
            Divider(color = Color.Black, thickness = 5.dp)
        }
    }
}

// DISPLAY TV SHOW LIST

@Composable
fun DisplayTvShows(selectedItem : (TvShow) -> (Unit)) {
    // Composable functions can store a single object in memory by using to remember composable.
    val tvShows = remember { TvShowList.tvShows }

    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(
            items = tvShows,
            itemContent = {
                TvShowListItem(tvShow = it, selectedItem)
            }
        )
    }
}