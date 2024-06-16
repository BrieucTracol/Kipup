package com.example.kipup.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kipup.ui.theme.BackGround
import com.example.kipup.ui.theme.Yellow

@Composable
fun outlinetext(text: String,fontSize: Int,padding: Int){
    Box {//on utilise une Box pour superposé le texte et son contour

        Text(
            modifier = Modifier.padding(padding.dp),
            text = text,
            color = BackGround,  //couleur du contour
            style = TextStyle.Default.copy(
                fontSize = fontSize.sp,
                fontWeight = FontWeight.Bold,
                drawStyle = Stroke(
                    miter = 10f,
                    width = 5f,
                    join = StrokeJoin.Round
                )
            ),

            )
        Text(
            modifier = Modifier.padding(padding.dp),
            text = text,
            color = Color.White, //couleur du titre
            style = TextStyle.Default.copy(
                fontSize = fontSize.sp,
                fontWeight = FontWeight.Bold,
            ),
        )
    }
}