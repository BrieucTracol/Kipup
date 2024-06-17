package com.example.kipup.composables.page

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.kipup.Database.Exo
import com.example.kipup.composables.Ui.MyTopAppBar
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.kipup.composables.Ui.Button.Boutonplusmoins
import com.example.kipup.ui.theme.BackGround
import com.example.kipup.ui.theme.Yellow
import kotlinx.coroutines.delay
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin
@Composable
fun TrainingPage(navController: NavHostController) {
    val exolist = remember { mutableStateListOf<Exo>() }
    LaunchedEffect(Unit) {//initialisation de la list avec des exos préfaits pour test
        exolist.addAll(
            listOf(
                Exo(exoId = 1, nom = "Curl", muscle = "Biceps"),
                Exo(exoId = 2, nom = "Squat", muscle = "Quadriceps"),
                Exo(exoId = 3, nom = "Dips", muscle = "Pectoraux")
            )
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        MyTopAppBar(navController)
        FicheExo(nom = "Curl", muscle = "Biceps", timer = 5)
        FicheExo(nom = "Curl", muscle = "Biceps", timer = 5)
    }
}


@Composable
fun FicheExo(nom: String,muscle: String,timer: Int){

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(10.dp)){
        Row(horizontalArrangement = Arrangement.SpaceBetween,
            modifier= Modifier
                .fillMaxWidth()
                .padding(10.dp)) {
            Text(text = nom)
            Text(text = muscle)
        }
        Row(horizontalArrangement = Arrangement.SpaceAround,
            modifier= Modifier
                .fillMaxWidth()
                .padding(10.dp)){
            Boutonplusmoins("Poids")
            Boutonplusmoins("Rep")
        }

        Divider(color = Yellow, thickness = 1.dp,
            modifier = Modifier
                .padding(horizontal = 40.dp))
    }
}
