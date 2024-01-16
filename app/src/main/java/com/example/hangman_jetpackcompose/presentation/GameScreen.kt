package com.example.hangman_jetpackcompose.presentation

import android.text.format.DateUtils
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.hangman_jetpackcompose.ui.theme.rubidoodle

@Composable
fun GameScreen(
    navController: NavController, difficulty: String?, length: String?
) {
    val viewModel = viewModel { GameScreenViewModel(difficulty, length) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = DateUtils.formatElapsedTime(viewModel.timerSeconds)
            )
            Text(
                text = "❤️".repeat(viewModel.lifeCount)
            )
        }
        Text(
            text = viewModel.secretWordCovered.value.uppercase(),
            fontFamily = rubidoodle,
            fontSize = 40.sp,
            lineHeight = 50.sp,
            textAlign = TextAlign.Center
        )
        Keyboard()
    }
    if (viewModel.winDialogState) {
        WinDialog(navController, viewModel.secretWord, viewModel.getScore(difficulty.toString()), difficulty, length){
            viewModel.switchWinDialogState()
        }
    }
    if (viewModel.lossDialogState) {
        LossDialog(navController, viewModel.secretWord, difficulty, length){
            viewModel.switchLossDialogState()
        }
    }
}
