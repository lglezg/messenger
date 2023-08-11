package com.lglez.messenger.authentication.welcome.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.lglez.messenger.R
import com.lglez.messenger.core.presentation.composables.RoundedButton
import com.lglez.messenger.core.presentation.navigation.Screen

@Composable
fun WelcomeScreen(navController: NavController) {
    Scaffold(
        backgroundColor = MaterialTheme.colors.background
    ) {
        WelcomeContent(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            navController = navController
        )
    }
}

@Composable
fun WelcomeContent(
    modifier: Modifier,
    navController: NavController
) {
    Box(modifier = modifier) {

        Text(
            modifier = Modifier
                .padding(top = 100.dp)
                .align(Alignment.TopCenter),
            text = stringResource(R.string.welcome_label),
            style = MaterialTheme.typography.h1
        )

        Image(
            modifier = Modifier.align(Alignment.Center),
            painter = painterResource(id = R.drawable.img_social_media),
            contentDescription = null
        )

        Column(
            modifier = Modifier
                .padding(horizontal = 30.dp)
                .padding(bottom = 100.dp)
                .align(Alignment.BottomCenter)
        ) {
            RoundedButton(
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .fillMaxWidth(),
                content = { Text(text = stringResource(R.string.signup_label)) }
            ) {
                navController.navigate(Screen.SIGN_UP)

            }
            RoundedButton(
                modifier = Modifier.fillMaxWidth(),
                background = MaterialTheme.colors.surface,
                content = { Text(text = stringResource(R.string.signin_label)) }
            ) {
                navController.navigate(Screen.SIGN_IN)
            }
        }
    }
}
