package com.example.kipup.composables.Ui.Button

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kipup.R
import com.example.kipup.ui.theme.Yellow


@Composable
fun Boutonplusmoins(buttonName: String) { //un bouton pour changer les valeurs de l'exo stocker dans la seance(actuellement il n'y a pas de BDD donc juste change le chiffre afficher

    var valeur by remember { mutableStateOf(0) }
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text= buttonName + ":",
            textAlign = TextAlign.Center,
            textDecoration = TextDecoration.Underline,
            color = Color.Black)
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            IconButton(onClick = { valeur++ }) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_arrow_drop_up_24),
                    contentDescription = "bouton pour augmenter la valeur",
                    tint = Yellow,
                    modifier = Modifier
                        .size(30.dp)
                        .fillMaxSize()
                )
            }
            Text(
                text = valeur.toString(),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .background(Color.Gray)
                    .size(15.dp, 20.dp)


            )
            IconButton(onClick = { valeur-- }) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_arrow_drop_down_24),
                    contentDescription = "bouton pour reduire la valeur",
                    tint = Yellow,
                    modifier = Modifier
                        .size(30.dp)
                        .fillMaxSize()
                )
            }
        }
    }
}

