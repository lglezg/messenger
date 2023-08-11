package com.lglez.messenger.home.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.lglez.messenger.R
import com.lglez.messenger.core.presentation.composables.RoundedTopBar
import com.lglez.messenger.core.presentation.composables.Screen
import com.lglez.messenger.core.presentation.composables.TopBarAction

@Composable
fun HomeScreen(navController: NavController) {
    Screen(
        topBar = {
            RoundedTopBar(
                title = R.string.home_screen_label,
                actions = {
                    TopBarAction(icon = R.drawable.ic_user_add) {

                    }
                }
            )
        }
    ) {

    }
}