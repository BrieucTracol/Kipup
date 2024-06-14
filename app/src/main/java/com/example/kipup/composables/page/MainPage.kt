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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.kipup.composables.MainPageButton
import com.example.kipup.composables.MyTopAppBar


@Composable
fun MainPage(modifier: Modifier = Modifier,navController: NavHostController) {
    Column(
        Modifier

        .background(Color.White)
        .fillMaxHeight())
    {
        MyTopAppBar(navController)
        Row(
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween

        ){
            MainPageButton(modifier = Modifier.weight(1f),1,onClick = {navController.navigate("training")})
            MainPageButton(modifier = Modifier.weight(1f),1,onClick = {navController.navigate("exercise")})

        }
        Row(
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween

        ){
            MainPageButton(modifier = Modifier.weight(1f),1,onClick = {navController.navigate("second")})
            MainPageButton(modifier = Modifier.weight(1f),1,onClick = {navController.navigate("second")})

        }


    }

}