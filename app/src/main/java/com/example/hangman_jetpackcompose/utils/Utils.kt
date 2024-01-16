package com.example.hangman_jetpackcompose.utils

import android.media.MediaPlayer
import com.example.hangman_jetpackcompose.HangmanApplication
import com.example.hangman_jetpackcompose.R

// QWERTZ lines for keyboard
val buttonList1stRow = listOf('Q', 'W', 'E', 'R', 'T', 'Z', 'U', 'I', 'O', 'P')
val buttonList2ndRow = listOf('A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L')
val buttonList3rdRow = listOf('Y', 'X', 'C', 'V', 'B', 'N', 'M')


// Loaded sound files
val ringSound: MediaPlayer = MediaPlayer.create(HangmanApplication.getAppContext(), R.raw.bell)
val fanfare: MediaPlayer = MediaPlayer.create(HangmanApplication.getAppContext(), R.raw.fanfare)
val duckSound: MediaPlayer = MediaPlayer.create(HangmanApplication.getAppContext(), R.raw.duck)
val fail: MediaPlayer = MediaPlayer.create(HangmanApplication.getAppContext(), R.raw.fail)