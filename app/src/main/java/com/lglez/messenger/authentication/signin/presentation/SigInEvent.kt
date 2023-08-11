package com.lglez.messenger.authentication.signin.presentation

sealed interface SigInEvent{
    data class EmailChange(val email: String) : SigInEvent
    data class PasswordChange(val password: String) : SigInEvent
    object SignIn : SigInEvent
}