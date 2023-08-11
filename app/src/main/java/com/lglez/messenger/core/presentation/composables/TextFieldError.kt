package com.lglez.messenger.core.presentation.composables

import androidx.annotation.StringRes

sealed interface TextFieldError{
    object Valid : TextFieldError
    data class Invalid(@StringRes val messageError: Int): TextFieldError
}