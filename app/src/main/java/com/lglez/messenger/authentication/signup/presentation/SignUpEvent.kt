package com.lglez.messenger.authentication.signup.presentation

sealed interface SignUpEvent{
    data class NameChange(val name: String) : SignUpEvent
    data class EmailChange(val email: String) : SignUpEvent
    data class PasswordChange(val password: String) : SignUpEvent
    data class ConfirmPasswordChange(val confirmPassword: String) : SignUpEvent
}