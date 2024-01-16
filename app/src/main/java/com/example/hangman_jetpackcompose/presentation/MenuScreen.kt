package com.example.hangman_jetpackcompose.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hangman_jetpackcompose.ui.theme.rubidoodle

@Composable
fun MenuScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            modifier = Modifier
                .clickable { navController.navigate("settings") },
            text = "New Game",
            fontFamily = rubidoodle,
            fontSize = 40.sp,
            fontWeight = FontWeight.ExtraBold
        )
        /*
        Text(
            text = "High Score",
            fontFamily = rubidoodle,
            fontSize = 40.sp,
            fontWeight = FontWeight.ExtraBold
        )
        */
    }
}