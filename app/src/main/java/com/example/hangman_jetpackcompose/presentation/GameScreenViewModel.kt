package com.example.hangman_jetpackcompose.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.hangman_jetpackcompose.data.pickSecretWord
import com.example.hangman_jetpackcompose.utils.duckSound
import com.example.hangman_jetpackcompose.utils.fail
import com.example.hangman_jetpackcompose.utils.fanfare
import com.example.hangman_jetpackcompose.utils.ringSound
import java.util.Timer
import kotlin.concurrent.timerTask

class GameScreenViewModel(difficulty: String?, length: String?) : ViewModel(
) {
    var winDialogState by mutableStateOf(false)
    var lossDialogState by mutableStateOf(false)
    val secretWord by mutableStateOf(pickSecretWord(getLength(length)))
    private val secretWordListed = secretWord.toList()
    private val guessedLetters = mutableListOf<Char>()
    var secretWordCovered = mutableStateOf(" _ ".repeat(secretWord.length))
    var lifeCount by mutableIntStateOf(getDifficulty(difficulty))
    var timerSeconds by mutableLongStateOf(0L)

    private val gameTimer = Timer()

    init {
        gameTimer.scheduleAtFixedRate(
            timerTask {
                timerSeconds += 1
            }, 1000, 1000
        )
    }

    fun switchWinDialogState() {
        winDialogState = !winDialogState
    }

    fun switchLossDialogState() {
        lossDialogState = !lossDialogState
    }

    private fun checkWinLoss() {
        if (lifeCount == 0) {

            gameTimer.cancel()
            fail.start()
            switchLossDialogState()
        }
        if (guessedLetters.size == secretWord.toCharArray().distinct().size) {

            gameTimer.cancel()
            fanfare.start()
            switchWinDialogState()
        }
    }


    fun evaluateInput(input: Char) {
        if (input in secretWordListed) {
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
            ringSound.start()
            checkWinLoss()
        } else {
            lifeCount -= 1
            duckSound.start()
            checkWinLoss()
        }
    }

    fun getScore(difficulty: String): Long {
        val lifeScore = lifeCount * 100
        val timeScore = timerSeconds * -5
        val diffMultiplier = when (difficulty) {
            "easy" -> 1
            "medium" -> 1.5
            "hard" -> 2
            else -> {
                1
            }
        }
        return ((lifeScore + timeScore + (diffMultiplier.toLong() * 10)) * diffMultiplier.toLong())
    }

    private fun getDifficulty(difficulty: String?): Int {
        return when (difficulty) {
            "easy" -> 10
            "medium" -> 8
            "hard" -> 5
            else -> {
                return 8
            }
        }
    }

    private fun getLength(difficulty: String?): IntRange {
        return when (difficulty) {
            "short" -> 4..5
            "medium" -> 6..7
            "long" -> 8..9
            else -> {
                return 6..7
            }
        }
    }


}