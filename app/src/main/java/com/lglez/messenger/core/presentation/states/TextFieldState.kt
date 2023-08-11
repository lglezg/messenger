package com.lglez.messenger.core.presentation.states

import androidx.annotation.StringRes


data class TextFieldState(
    val value: String = "",
    @StringRes val onError : Int? = null,
)
