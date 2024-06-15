package com.example.kipup.composables.page

import ExoEntryViewModel
import ExoUiState
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import com.example.kipup.composables.AddButton
import com.example.kipup.composables.MyTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier


@Composable
fun ExercisePage(navController: NavHostController,viewModel: ExoEntryViewModel = viewModel(factory = AppViewModelProvider.Factory)) {
    var showDialog by remember { mutableStateOf(false) }


    Column {
        MyTopAppBar(navController)
        Text(text = "ExercisePage")
        AddButton(onClick = { showDialog = true })

    /*    if (showDialog) {
            ExoEntryNotif(
                exoUiState = viewModel.exoUiState,
                onExoValueChange = { viewModel.updateUiState(it.exoDetails) },
                onSaveClick = {
                    showDialog = false // Ferme la boîte de dialogue après avoir cliqué sur "Confirmer"
                },
                onDismissRequest = { showDialog = false },
                showDialog = showDialog, // Passez l'état showDialog à ExoEntryNotif
                modifier = Modifier
            )
        } */
    }

}

@Composable
fun ExoEntryNotif(
    exoUiState: ExoUiState,
    onExoValueChange: (ExoUiState) -> Unit,
    onSaveClick: () -> Unit,
    modifier: Modifier = Modifier,
    showDialog: Boolean,
    onDismissRequest: () -> Unit // Callback pour fermer la boîte de dialogue
) {
    // État local pour gérer showDialog
    val showDialogState = remember { mutableStateOf(showDialog) }

    if (showDialogState.value) {
        AlertDialog(
            onDismissRequest = { onDismissRequest() },
            title = { Text(text = "Nouvelle Exercice") },
            text = {
                Column {
                    TextField(
                        value = exoUiState.exoDetails.nom,
                        onValueChange = { onExoValueChange(exoUiState.copy(exoDetails = exoUiState.exoDetails.copy(nom = it))) },
                        label = { Text("Nom Exercice") }
                    )
                    TextField(
                        value = exoUiState.exoDetails.muscle,
                        onValueChange = { onExoValueChange(exoUiState.copy(exoDetails = exoUiState.exoDetails.copy(muscle = it))) },
                        label = { Text("Nom Muscle") }
                    )
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        onSaveClick()
                        showDialogState.value = false // Ferme la boîte de dialogue après avoir cliqué sur "Confirmer"
                    },
                    enabled = exoUiState.isEntryValid
                ) {
                    Text("Confirmer")
                }
            }
        )
    }
}