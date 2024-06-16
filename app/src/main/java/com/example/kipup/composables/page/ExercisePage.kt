package com.example.kipup.composables.page

import ExoUiState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import com.example.kipup.composables.Ui.Button.AddButton
import com.example.kipup.composables.Ui.MyTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kipup.Database.Exo
import com.example.kipup.composables.Ui.Button.DropDownMenu
import com.example.kipup.composables.Ui.ExoCard
import com.example.kipup.ui.theme.BackGround
import com.example.kipup.ui.theme.Yellow


@Composable
fun ExercisePage(navController: NavHostController) {
    var showDialog by remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()
    val exocards = remember { mutableStateListOf<Exo>() } //list d'exo pour combler le manque de BDD

    LaunchedEffect(Unit) {//initialisation de la list avec des exos préfaits pour test
        exocards.addAll(
            listOf(
                Exo(exoId = 1, nom = "Curl", muscle = "Biceps"),
                Exo(exoId = 2, nom = "Squat", muscle = "Quadriceps"),
                Exo(exoId = 3, nom = "Dips", muscle = "Pectoraux")
            )
        )
    }
    Column(

        Modifier
            .fillMaxSize()
            .background(BackGround)
    ) {
        MyTopAppBar(navController)
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()

        ){
        Text(
            text = "ExercisePage", // nom de la page
            style = TextStyle.Default.copy(
                fontSize = 30.sp,
            ),
            modifier = Modifier.padding(start = 20.dp, top = 20.dp, bottom = 10.dp)
        )

            DropDownMenu(onValidClick = { triChoisi ->
                exocards.sortWith(compareBy(
                    when (triChoisi) {
                        "Id" -> { exo: Exo -> exo.exoId }
                        "nom" -> { exo: Exo -> exo.nom }
                        "muscle" -> { exo: Exo -> exo.muscle }
                        else -> { exo: Exo -> exo.exoId }
                    }
                ))
            })
        }
        /* Divider(color = BackGround, thickness = 1.dp,
             modifier = Modifier
                 .padding(horizontal = 40.dp)) */
        LazyVerticalGrid(
            GridCells.Fixed(2),
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
        ) {
            itemsIndexed(exocards) { index, cardContent ->
                ExoCard(cardContent.nom, cardContent.muscle)
            }
            item {
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(20.dp)
                        .size(160.dp, 120.dp),
                    contentAlignment = Alignment.Center
                ) {
                    AddButton(onClick = { showDialog = true })
                }
            }
        }
    }

    if (showDialog) { // si on a appuyer sur le bouton on affiche le pop up de création d'exo
        ExoEntryNotif(
            // exoUiState = viewModel.exoUiState,
            // onExoValueChange = { viewModel.updateUiState(it.exoDetails) },
            onSaveClick = {
                    nom, muscle -> exocards.add(Exo(exoId = 1, nom, muscle))
                showDialog = false // Ferme la boîte de dialogue après avoir cliqué sur "Confirmer"

            },
            onDismissRequest = { showDialog = false },
            showDialog = showDialog, // Passe l'état showDialog à ExoEntryNotif
            modifier = Modifier
        )
    }

}


@Composable
fun ExoEntryNotif(// composable pop up qui permet de rentrer un exercice
    //exoUiState: ExoUiState,
    //onExoValueChange: (ExoUiState) -> Unit,
    onSaveClick: (String,String) -> Unit,
    modifier: Modifier = Modifier,
    showDialog: Boolean,
    onDismissRequest: () -> Unit // Callback pour fermer la boîte de dialogue
) {
    // État local pour gérer showDialog
    val showDialogState = remember { mutableStateOf(showDialog) }
    var val1 by remember { mutableStateOf("") }
    var val2 by remember { mutableStateOf("") }

    if (showDialogState.value) {
        AlertDialog(
            onDismissRequest = { onDismissRequest() },
            title = { Text(text = "Nouvelle Exercice") },
            text = {
                Column {
                    TextField(
                        value = val1,//exoUiState.exoDetails.nom,
                        onValueChange = {val1=it},       //{ onExoValueChange(exoUiState.copy(exoDetails = exoUiState.exoDetails.copy(nom = it))) },
                        label = { Text("Nom Exercice") }
                    )
                    TextField(
                        value = val2,//exoUiState.exoDetails.muscle,
                        onValueChange = {val2=it},//{ onExoValueChange(exoUiState.copy(exoDetails = exoUiState.exoDetails.copy(muscle = it))) },
                        label = { Text("Nom Muscle") }
                    )
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        onSaveClick(val1,val2)
                        showDialogState.value = false // Ferme la boîte de dialogue après avoir cliqué sur "Confirmer"
                    },
                    //enabled = exoUiState.isEntryValid
                ) {
                    Text("Confirmer")
                }
            }
        )
    }
}