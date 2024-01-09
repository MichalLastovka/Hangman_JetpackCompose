package com.example.hangman_jetpackcompose.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import java.util.Timer
import kotlin.concurrent.timerTask

class GameScreenViewModel : ViewModel(

) {
    val secretWord by mutableStateOf("DoggyStyle")
    val secretWordCovered = mutableStateOf(" _ ".repeat(secretWord.length))
    val lifeCount = mutableIntStateOf(8)
    var timerSeconds by mutableStateOf(0L)

    init {
        val gameTimer = Timer()
        gameTimer.scheduleAtFixedRate(
            timerTask()
            {
                timerSeconds += 1
            }, 1000, 1000
        )
    }

}