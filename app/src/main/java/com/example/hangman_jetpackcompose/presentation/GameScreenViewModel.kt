package com.example.hangman_jetpackcompose.presentation

import android.media.MediaPlayer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.hangman_jetpackcompose.HangmanApplication
import com.example.hangman_jetpackcompose.R
import com.example.hangman_jetpackcompose.data.pickSecretWord
import java.util.Timer
import kotlin.concurrent.timerTask

class GameScreenViewModel : ViewModel(

) {

    var dialogState by mutableStateOf(false)
    val secretWord by mutableStateOf(pickSecretWord(8))
    val guessedLetters = mutableListOf<Char>()
    var secretWordCovered = mutableStateOf(" _ ".repeat(secretWord.length))
    var lifeCount by mutableIntStateOf(8)
    var timerSeconds by mutableLongStateOf(0L)

    init {
        val gameTimer = Timer()
        gameTimer.scheduleAtFixedRate(
            timerTask {
                timerSeconds += 1
            }, 1000, 1000
        )
    }


    fun evaluateInput(input: Char) {
        println(input)
        println(secretWord)
        println(secretWord.toList())
        if (input in secretWord.toList()) {
            val ringSound = MediaPlayer.create(HangmanApplication.getAppContext(), R.raw.bell)
            ringSound.start()
            guessedLetters.add(input)
            var toDisplay = ""
            for (char in secretWord) {
                toDisplay += if (char in guessedLetters) {
                    " $char "
                } else {
                    " _ "
                }
            }
            secretWordCovered = mutableStateOf(toDisplay)
            dialogState = true
        } else {
            val duckSound = MediaPlayer.create(HangmanApplication.getAppContext(), R.raw.duck)
            duckSound.start()
            lifeCount -= 1
        }
    }


}