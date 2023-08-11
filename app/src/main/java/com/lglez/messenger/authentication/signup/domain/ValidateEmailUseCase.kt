package com.lglez.messenger.authentication.signup.domain

import com.lglez.messenger.R
import com.lglez.messenger.core.presentation.composables.TextFieldError
import javax.inject.Inject

class ValidateEmailUseCase @Inject constructor(){
    operator fun invoke(email:String): Int? {
        if (email.isEmpty()) return R.string.required_label
         val emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$".toRegex()
        return if (!emailRegex.matches(email))
            R.string.email_error_label
        else
            null

    }
}