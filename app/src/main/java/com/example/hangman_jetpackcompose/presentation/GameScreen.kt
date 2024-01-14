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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun GameScreen(

) {
    val viewModel: GameScreenViewModel = viewModel()

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ){
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = DateUtils.formatElapsedTime(viewModel.timerSeconds)
            )
            Text(
                text = "❤️".repeat(viewModel.lifeCount)
            )
        }
        Text(
            text = viewModel.secretWordCovered.value,
            fontSize = 40.sp
        )
        Keyboard()
    }
    if (viewModel.winDialogState){
        WinDialog(viewModel.secretWord) {
            viewModel.switchWinDialogState()
        }
    }
    if (viewModel.lossDialogState){
        LossDialog(viewModel.secretWord) {
            viewModel.switchLossDialogState()
        }
    }

}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun PrevGameScreen(

) {
    GameScreen()
}