package com.example.kipup.composables.Ui.Button

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.kipup.ui.theme.BackGround

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDownMenu( //drop down menu permettant de trier les exos selon differents critères
    onValidClick: (String) -> Unit,
) {
    val context = LocalContext.current
    val choixtri = arrayOf("Id", "nom", "muscle")
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf(choixtri[0]) }


    Box(
        modifier = Modifier
            .size(height = 80.dp, width = 150.dp)
            .padding(top = 20.dp, bottom = 10.dp, end = 8.dp)

    ) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            }
        ) {
            TextField(
                value = selectedText,
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = BackGround,
                    unfocusedTextColor = Color.Black,
                    focusedTextColor = Color.Black
                ),
                        modifier = Modifier.menuAnchor()

            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }

            ) {
                choixtri.forEach { item ->
                    DropdownMenuItem(
                        text = { Text(text = item) },
                        onClick = {
                            selectedText = item
                            onValidClick(selectedText)
                            Log.d("test",item)
                            expanded = false

                        },

                    )
                }
            }
        }
    }
}