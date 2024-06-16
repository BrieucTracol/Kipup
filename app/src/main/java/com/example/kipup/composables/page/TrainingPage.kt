package com.example.kipup.composables.page

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.kipup.composables.Ui.MyTopAppBar

@Composable
fun TrainingPage(navController: NavHostController) {
    Column {
        MyTopAppBar(navController)

    }
}