package com.example.kipup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kipup.composables.MyTopAppBar
import com.example.kipup.ui.theme.KipupTheme
import com.example.kipup.Database.MyDataBase
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KipupTheme {//test
                MyApp()
                // A surface container using the 'background' color from the theme

            }
        }
    }
}
@Preview
@Composable
fun MyApp(modifier: Modifier = Modifier) {
    MyTopAppBar()
    getDataBase()
}


