package com.example.hangman_jetpackcompose.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import com.example.hangman_jetpackcompose.ui.theme.WinDialogColor
import com.example.hangman_jetpackcompose.ui.theme.rubidoodle

@Composable
fun WinDialog(
    navController: NavController,
    secretWord: String,
    score: Long,
    stateDiff: String?,
    stateLength: String?,
    onDismiss: () -> Unit
) {
    Dialog(
        onDismissRequest = {},
        properties = DialogProperties(
            dismissOnClickOutside = false,
            usePlatformDefaultWidth = false
        )
    ) {
        Card(
            elevation = CardDefaults.cardElevation(5.dp),
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .border(1.dp, Color.Black, RoundedCornerShape(15.dp)),

            ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(WinDialogColor)
                    .padding(15.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Victory!",
                    color = Color.Black,
                    fontFamily = rubidoodle,
                    fontSize = 30.sp
                )
                Text(
                    text = "The word you were looking for is:",
                    color = Color.Black,
                    modifier = Modifier.padding(vertical = 5.dp),
                    fontFamily = rubidoodle,
                    fontSize = 15.sp
                )
                Text(
                    text = secretWord.uppercase(),
                    color = Color.Black,
                    modifier = Modifier.padding(vertical = 10.dp),
                    fontFamily = rubidoodle,
                    fontSize = 30.sp
                )
                Text(
                    text = "Score: $score",
                    color = Color.Black,
                    modifier = Modifier.padding(vertical = 10.dp),
                    fontFamily = rubidoodle,
                    fontSize = 30.sp
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    TextButton(
                        onClick = {
                            onDismiss()
                            navController.navigate("menu")
                        }
                    ) {
                        Text(
                            text = "Menu",
                            color = Color.Black,
                            fontFamily = rubidoodle,
                            fontSize = 20.sp
                        )
                    }
                    TextButton(
                        onClick = {
                            onDismiss()
                            navController.navigate("game/${stateDiff!!.lowercase()}/${stateLength!!.lowercase()}")
                        }
                    ) {
                        Text(
                            text = "Play again",
                            color = Color.Black,
                            fontFamily = rubidoodle,
                            fontSize = 20.sp
                        )
                    }
                }
            }
        }
    }
}

