package com.lglez.messenger.authentication.signup.domain

import com.lglez.messenger.R
import javax.inject.Inject

class ValidateNameUseCase @Inject constructor(){
    operator fun invoke(email:String): Int? {
        if (email.isEmpty()) return R.string.required_label
        val emailRegex = "^[a-zA-Z0-9\\.-]+\$".toRegex()
        return if (!emailRegex.matches(email))
            R.string.name_error_label
        else
            null

    }
}