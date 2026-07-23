package com.example.helloworld

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.*
import com.example.helloworld.ui.GreetingScreen
import com.example.helloworld.ui.theme.HelloWorldTheme
import com.example.helloworld.screens.ProfileScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {

            var darkTheme by remember { mutableStateOf(false) }
            var currentScreen by remember { mutableStateOf("hello") }

            HelloWorldTheme(darkTheme = darkTheme) {

                if (currentScreen == "hello") {
                    GreetingScreen(
                        onNavigateToProfile = {
                            currentScreen = "profile"
                        }
                    )
                } else {
                    ProfileScreen()
                }
            }
        }
    }
}