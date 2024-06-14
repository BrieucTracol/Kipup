package com.example.kipup.composables

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.kipup.ui.theme.Yellow

data class ButtonPreviewParameter(
    val text: String,
    val backgroundColor: Color,
)
class ButtonPreviewParameterProvider : PreviewParameterProvider<ButtonPreviewParameter> {
    override val values = sequenceOf(
        ButtonPreviewParameter(
            text = "Default",
            backgroundColor = Yellow

        )
    )
}