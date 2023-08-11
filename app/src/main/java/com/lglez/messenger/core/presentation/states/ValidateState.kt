package com.lglez.messenger.core.presentation.states

import androidx.annotation.StringRes
import com.lglez.messenger.R


data class ValidateState(
    val isValid : Boolean = false,
    @StringRes val  errorMessage: Int = R.string.required_label
)
