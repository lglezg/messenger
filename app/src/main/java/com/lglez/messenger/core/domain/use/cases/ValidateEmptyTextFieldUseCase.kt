package com.lglez.messenger.core.domain.use.cases

class ValidateEmptyTextFieldUseCase {
    operator fun invoke(value: String) : Boolean{
        return value.isNotEmpty()
    }
}