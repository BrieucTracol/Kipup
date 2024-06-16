package com.example.kipup.composables.Ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.*
import com.example.kipup.ui.theme.Yellow
import com.example.kipup.ui.theme.Yellow2
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.kipup.ui.theme.BackGround

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(navController: NavHostController) {
    Surface(
        shadowElevation = 3.dp,
        color = Yellow
    ) {
        TopAppBar(

            title = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { navController.popBackStack() }) { //bouton de retour
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                    Box {//on utilise une Box pour superposé le texte et son contour
                        Text(
                            text = "Kipup",
                            color = BackGround,  //couleur du contour
                            style = TextStyle.Default.copy(
                                fontSize = 36.sp,
                                fontWeight = FontWeight.Bold,
                                drawStyle = Stroke(
                                    miter = 10f,
                                    width = 5f,
                                    join = StrokeJoin.Round
                                )
                            ),

                            )
                        Text(
                            text = "Kipup",
                            color = Color.White, //couleur du titre
                            style = TextStyle.Default.copy(
                                fontSize = 36.sp,
                                fontWeight = FontWeight.Bold,
                            ),
                            modifier = Modifier.padding(end=16.dp)
                            )
                    }
                }
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Yellow),
            scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(),
            modifier = Modifier.fillMaxWidth(),
        )
    }
}