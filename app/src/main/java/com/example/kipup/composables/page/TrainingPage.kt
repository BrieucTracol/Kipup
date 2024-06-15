package com.example.kipup.composables.page

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.kipup.composables.AddButton
import com.example.kipup.composables.MyTopAppBar

@Composable
fun TrainingPage(navController: NavHostController) {
    Column {
        MyTopAppBar(navController)

    }
}