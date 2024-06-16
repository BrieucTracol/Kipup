package com.example.kipup

import ExoEntryViewModel
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import com.example.kipup.ui.theme.KipupTheme
import com.example.kipup.composables.page.MainPage
import com.example.kipup.composables.page.NavigationGraph

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            KipupTheme {//test
                val viewModel: ExoEntryViewModel by viewModels { AppViewModelProvider.Factory }
                val navController = rememberNavController()
                NavigationGraph(navController = navController)
                // A surface container using the 'background' color from the theme

            }
        }
    }
}




