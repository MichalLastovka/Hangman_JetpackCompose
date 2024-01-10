package com.example.hangman_jetpackcompose.data

import com.example.hangman_jetpackcompose.HangmanApplication
import java.io.BufferedReader
import java.io.InputStreamReader

private val nouns = InputStreamReader(HangmanApplication.getAppContext().assets.open("nouns.csv"))
private val readerNouns = BufferedReader(nouns)
private val nounList = readerNouns.readLines().toMutableList()

fun pickSecretWord(length: Int): String {
    val suitableWords = nounList.filter { it.length == length }
    println(suitableWords.random())
    return suitableWords.random().lowercase()
}