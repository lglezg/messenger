package com.lglez.messenger.authentication.signup.presentation

import com.lglez.messenger.core.presentation.states.TextFieldState

data class SignupState(
    val name: TextFieldState = TextFieldState(),
    val email: TextFieldState = TextFieldState(),
    val password: TextFieldState = TextFieldState(),
    val confirmPassword: TextFieldState = TextFieldState(),
)
