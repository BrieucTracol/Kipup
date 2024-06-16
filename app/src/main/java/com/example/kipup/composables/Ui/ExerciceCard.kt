package com.example.kipup.composables.Ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontVariation.width
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.kipup.composables.outlinetext
import com.example.kipup.ui.theme.BackGround
import com.example.kipup.ui.theme.Yellow

@Composable
fun ExoCard(nom: String,muscle: String){ //prend les differentes key de la BDD pour faire une card correspondant a l'exercice
    Card(
        colors = CardDefaults.cardColors(
            containerColor = BackGround,
        ),
        border = BorderStroke(1.dp, Color.Yellow),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .padding(20.dp)
            .size(160.dp,120.dp)

    ){
        Text(
            text = nom, //a remplacer par la valeur nom de la BDD
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Center,
        )
        Text(
            text = muscle, //a remplacer par la valeur muscle de la BDD
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Center,
        )
    }
}