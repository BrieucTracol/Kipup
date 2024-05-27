package com.example.kipup.composables

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.text.font.*
import com.example.kipup.ui.theme.White
import com.example.kipup.ui.theme.Yellow
import com.example.kipup.ui.theme.Yellow2


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun MyTopAppBar() {
    TopAppBar(
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Kipup",
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                    color = White,
                    modifier = Modifier.padding(end = 16.dp)

                )
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Yellow)
    )
}