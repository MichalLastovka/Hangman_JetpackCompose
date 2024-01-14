package com.example.hangman_jetpackcompose.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hangman_jetpackcompose.ui.theme.ButtonsColor

@Composable
fun LetterButton(
    text: Char,
    onClick: (Char) -> Unit
) {
    var wasClicked by rememberSaveable { mutableStateOf(false) }
    TextButton(
        onClick = {
            onClick(text)
            wasClicked = true
        },
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .size(35.dp)
            .background(if (!wasClicked) ButtonsColor else Color.LightGray),
        enabled = !wasClicked
    ) {
        Text(
            text = text.toString(),
            color = if(wasClicked)Color.Gray else Color.Black,
            style = if(wasClicked) TextStyle(textDecoration = TextDecoration.LineThrough) else TextStyle()
            )
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