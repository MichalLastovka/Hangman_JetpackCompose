package com.example.hangman_jetpackcompose.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LetterButton(
    text: Char,
    onClick: (Char) -> Unit
) {
    TextButton(
        onClick = { onClick(text) },
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .size(35.dp)
            .background(Color.Red),
    ) {
        Text(text = text.toString())
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun PrevLetterButton(

) {
    LetterButton('A') {
        println("A")
    }
}