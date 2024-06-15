package com.example.kipup.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kipup.R
import com.example.kipup.ui.theme.Yellow




//bouton de la page principale

@Composable
fun MainPageButton(modifier: Modifier = Modifier,imageId: Int,onClick: () -> Unit){
    //les differentes valeurs des boutons de la main page a modifier
    val myPadding = 16.dp
    val myHeight = 200.dp
    val myColor = Yellow
    val myShape = 20.dp

   Button(onClick = onClick,
   colors = ButtonDefaults.buttonColors(containerColor = myColor), //changer la couleur du bouton
   modifier = modifier
       .fillMaxWidth()
       .padding(myPadding)
       .height(myHeight),
       shape = RoundedCornerShape(myShape),
       elevation = ButtonDefaults.buttonElevation( // Ajout d'une élévation pour l'effet de volume
               defaultElevation = 20.dp,
       pressedElevation = 8.dp)
   ) {

       Column(
           verticalArrangement = Arrangement.Center,
           horizontalAlignment = Alignment.CenterHorizontally
       ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_add_24),
                contentDescription = "...",
                tint = Color.White,
                modifier = Modifier
                        .size(40.dp)
            )
           Text("Alfred Sisley")
           Text("3 minutes ago")
       }

   }


    }

