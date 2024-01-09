package com.example.hangman_jetpackcompose

import android.app.Application
import android.content.Context

class HangmanApplication: Application() {
    init {
        app = this
    }
    companion object {
        private lateinit var app: HangmanApplication
        fun getAppContext(): Context = app.applicationContext
    }
}