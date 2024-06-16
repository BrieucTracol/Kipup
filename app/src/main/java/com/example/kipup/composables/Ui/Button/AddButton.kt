package com.example.kipup.composables.Ui.Button

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kipup.R
import com.example.kipup.ui.theme.Yellow

//Bouton d'ajout de nouveaux elements Exo/serie
@Composable
fun AddButton(onClick: () -> Unit){//
    IconButton(onClick = onClick) {
        Icon(
            painter = painterResource(id = R.drawable.baseline_add_24),
            contentDescription = "...",
            tint = Color.Yellow,
            modifier = Modifier
                .size(60.dp)
                .fillMaxSize()

        )
    }
}