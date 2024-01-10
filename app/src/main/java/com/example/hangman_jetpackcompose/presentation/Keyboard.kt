package com.example.hangman_jetpackcompose.presentation

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.hangman_jetpackcompose.utils.buttonList1stRow
import com.example.hangman_jetpackcompose.utils.buttonList2ndRow
import com.example.hangman_jetpackcompose.utils.buttonList3rdRow

@Composable
fun Keyboard(
) {
    val viewModel: GameScreenViewModel = viewModel()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 2.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterHorizontally)
        ) {
            for (letter in buttonList1stRow) {
                LetterButton(text = letter) {
                    viewModel.evaluateInput(letter.lowercaseChar())
                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 2.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterHorizontally)
        ) {
            for (letter in buttonList2ndRow) {
                LetterButton(text = letter) {
                    viewModel.evaluateInput(letter.lowercaseChar())
                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 2.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterHorizontally)
        ) {
            for (letter in buttonList3rdRow) {
                LetterButton(text = letter) {
                    viewModel.evaluateInput(letter.lowercaseChar())
                }
            }
        }
    }
}

@Preview(
    showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun PrevKeyboard(

) {
    Keyboard()
}