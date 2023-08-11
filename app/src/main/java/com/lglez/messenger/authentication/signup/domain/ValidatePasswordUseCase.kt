package com.lglez.messenger.authentication.signup.domain

import com.lglez.messenger.R
import com.lglez.messenger.core.presentation.composables.TextFieldError
import javax.inject.Inject

class ValidatePasswordUseCase @Inject constructor() {

    operator fun invoke(password: String): Int? {
        if (password.isEmpty()) return R.string.required_label
        val passwordRegex =
            "^(?=.*[0-9])(?=.*[A-Z])(?=.*[!\"#\$%&'()*+,-./:;<=>?@^_`{|}~])[a-zA-Z0-9!\"#\$%&'()*+,-./:;<=>?@^_`{|}~]{8,}$".toRegex()
        return if (passwordRegex.matches(password))
            R.string.required_label
        else
            null
    }
}