package com.example.hangman_jetpackcompose.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.chargemap.compose.numberpicker.ListItemPicker
import com.example.hangman_jetpackcompose.ui.theme.rubidoodle

@Composable
fun SettingsScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Text(
            text = "Chose difficulty:",
            color = if (isSystemInDarkTheme()) Color.White else Color.Black,
            fontSize = 30.sp,
            fontFamily = rubidoodle
        )
        val possibleDiff = listOf("Easy", "Medium", "Hard")
        var stateDiff by remember { mutableStateOf(possibleDiff[1]) }
        ListItemPicker(
            label = { it },
            value = stateDiff,
            onValueChange = { stateDiff = it },
            dividersColor = Color.Black,
            list = possibleDiff,
            textStyle = TextStyle(
                fontSize = 20.sp,
                color = if (isSystemInDarkTheme()) Color.White else Color.Black,
                fontFamily = rubidoodle
            )
        )

        Text(
            text = "Chose word length:",
            fontSize = 30.sp,
            color = if (isSystemInDarkTheme()) Color.White else Color.Black,
            fontFamily = rubidoodle
        )
        val possibleLength = listOf("Short", "Medium", "Long")
        var stateLength by remember { mutableStateOf(possibleLength[1]) }

        ListItemPicker(
            label = { it },
            value = stateLength,
            onValueChange = { stateLength = it },
            dividersColor = if (isSystemInDarkTheme()) Color.White else Color.Black,
            list = possibleLength,
            textStyle = TextStyle(
                fontSize = 20.sp,
                color = if (isSystemInDarkTheme()) Color.White else Color.Black,
                fontFamily = rubidoodle
            )
        )

        Text(
            modifier = Modifier
                .clickable { navController.navigate("game/${stateDiff.lowercase()}/${stateLength.lowercase()}") }
                .padding(vertical = 40.dp),
            text = "Start Game",
            color = if (isSystemInDarkTheme()) Color.White else Color.Black,
            fontFamily = rubidoodle,
            fontSize = 25.sp
        )

        Text(
            modifier = Modifier.clickable { navController.navigate("menu") },
            text = "Back",
            color = if (isSystemInDarkTheme()) Color.White else Color.Black,
            fontFamily = rubidoodle,
            fontSize = 25.sp
        )

    }
}
