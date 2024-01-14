package com.example.hangman_jetpackcompose.presentation

import android.view.Menu
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun Menu(

) {
    Column(
    ) {
        Text(
            text = "New Game"
        )
        Text(
            text = "Options"
        )
        Text(text = "Exit")
    }
}