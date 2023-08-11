package com.lglez.messenger.authentication.signup.domain


import javax.inject.Inject

class ValidateFormUseCase @Inject constructor(
    private val validateNameUseCase: ValidateNameUseCase,
    private val validateEmailUseCase: ValidateEmailUseCase,
    private val validatePasswordUseCase: ValidatePasswordUseCase,
    private val validateConfirmPasswordUseCase: ValidateConfirmPasswordUseCase,
) {
    operator fun invoke(name: String,email: String,password: String,confirmPassword: String): Boolean {
        val nameError = validateNameUseCase(name)
        val emailError = validateEmailUseCase(email)
        val passwordError = validatePasswordUseCase(password)
        val confirmPasswordError = validateConfirmPasswordUseCase(password, confirmPassword)
        if (nameError != null) return false
        if (emailError != null) return false
        if (passwordError != null) return false
        if (confirmPasswordError != null) return false
       return true
    }
}