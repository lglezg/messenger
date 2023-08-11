package com.lglez.messenger.authentication.signup.domain

import com.lglez.messenger.R
import com.lglez.messenger.core.presentation.composables.TextFieldError
import javax.inject.Inject

class ValidateConfirmPasswordUseCase @Inject constructor(){

    operator fun invoke(password: String,confirmPassword: String): Int? {
            return if (confirmPassword == password)
                null
        else R.string.confirm_password_error_label
    }
}