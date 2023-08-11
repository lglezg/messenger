package com.lglez.messenger.authentication.signup.presentation

import androidx.lifecycle.ViewModel
import com.lglez.messenger.authentication.signup.domain.SignUpUseCase
import com.lglez.messenger.authentication.signup.domain.ValidateConfirmPasswordUseCase
import com.lglez.messenger.authentication.signup.domain.ValidateEmailUseCase
import com.lglez.messenger.authentication.signup.domain.ValidateNameUseCase
import com.lglez.messenger.authentication.signup.domain.ValidatePasswordUseCase
import com.lglez.messenger.core.presentation.states.TextFieldState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject


@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val signUpUseCase: SignUpUseCase,
    private val validateEmailUseCase: ValidateEmailUseCase,
    private val validatePasswordUseCase: ValidatePasswordUseCase,
    private val validateConfirmPasswordUseCase: ValidateConfirmPasswordUseCase,
    private val validateNameUseCase: ValidateNameUseCase,
): ViewModel(){

    private val _uiState = MutableStateFlow(SignupState())
    val uiState : StateFlow<SignupState> = _uiState.asStateFlow()

    fun onEvent(event: SignUpEvent) {
        when (event) {
            is SignUpEvent.ConfirmPasswordChange -> {
                _uiState.update { state ->
                    state.copy(
                        confirmPassword = TextFieldState(
                            value = event.confirmPassword,
                            onError = validateConfirmPasswordUseCase(
                                _uiState.value.password.value,
                                event.confirmPassword
                            )
                        )
                    )
                }
            }

            is SignUpEvent.EmailChange -> _uiState.update { state ->
                state.copy(
                    email = TextFieldState(
                        value = event.email,
                        onError = validateEmailUseCase(event.email)
                    )
                )
            }

            is SignUpEvent.PasswordChange -> _uiState.update { state ->
                state.copy(
                    password = TextFieldState(
                        value = event.password,
                        onError = validatePasswordUseCase(event.password)
                    )
                )
            }

            is SignUpEvent.NameChange ->  _uiState.update { state ->
                state.copy(
                    name = TextFieldState(
                        value = event.name,
                        onError = validateNameUseCase(event.name)
                    )
                )
            }
        }
    }
}