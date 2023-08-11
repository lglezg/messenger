package com.lglez.messenger.authentication.signin.presentation

import com.lglez.messenger.core.presentation.states.TextFieldState

data class SignInState(
    val email: TextFieldState = TextFieldState(),
    val password: TextFieldState = TextFieldState(),
)
