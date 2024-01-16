package com.example.hangman_jetpackcompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.hangman_jetpackcompose.ui.theme.Hangman_JetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Hangman_JetpackComposeTheme {
                // A surface container using the 'background' color from the theme

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HangmanApp()
                }
            }
        }
    }
}

@Composable
fun HangmanApp(

) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "menu") {
        composable("menu") {
            MenuScreen(navController)
        }
        composable("settings") {
            SettingsScreen(navController)
        }
        composable(
            "game"+"/{difficulty}/{length}",
            listOf(
                navArgument(
                    "difficulty"
                ){
                    type = NavType.StringType
                    defaultValue = "medium"
                },
                navArgument(
                    "length"
                ){
                    type = NavType.StringType
                    defaultValue = "medium"
                }
            )
        ) { entry ->
            GameScreen(navController, difficulty = entry.arguments?.getString("difficulty"), length = entry.arguments?.getString("length"))
        }

    }
}
