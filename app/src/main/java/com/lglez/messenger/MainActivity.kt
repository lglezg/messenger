package com.lglez.messenger

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.lglez.messenger.core.presentation.navigation.Navigation
import com.lglez.messenger.ui.theme.MessengerTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            MessengerTheme {
                Navigation(navController = navController)
            }
        }
    }
}

