package com.example.kipup.composables.page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.kipup.R
import com.example.kipup.composables.Ui.Button.MainPageButton
import com.example.kipup.composables.Ui.MyTopAppBar
import com.example.kipup.ui.theme.BackGround


@Composable
fun MainPage(modifier: Modifier = Modifier,navController: NavHostController) {


    Column(
        Modifier

        .background(BackGround)
        .fillMaxHeight())
    {
        MyTopAppBar(navController)
        Row(
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween

        ){
            MainPageButton(modifier = Modifier.weight(1f),R.drawable.dumbbell_8_svgrepo_com,onClick = {navController.navigate("training")},"seance")
            MainPageButton(modifier = Modifier.weight(1f),R.drawable.baseline_add_24,onClick = {navController.navigate("exercise")},"exercice")

        }
        Row(
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween

        ){
            MainPageButton(modifier = Modifier.weight(1f),R.drawable.baseline_add_24,onClick = {navController.navigate("second")},"serie")
            MainPageButton(modifier = Modifier.weight(1f),R.drawable.baseline_add_24,onClick = {navController.navigate("second")},"")

        }


    }

}