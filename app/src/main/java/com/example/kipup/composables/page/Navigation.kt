package com.example.kipup.composables.page



import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { MainPage(modifier = Modifier,navController) }
        composable("training") { TrainingPage(navController) }
        composable("exercise") { ExercisePage(navController) }
    }
}

