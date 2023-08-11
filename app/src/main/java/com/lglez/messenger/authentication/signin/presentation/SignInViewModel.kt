package com.lglez.messenger.authentication.signin.presentation

import androidx.lifecycle.ViewModel
import com.lglez.messenger.core.domain.use.cases.ValidateEmptyTextFieldUseCase
import com.lglez.messenger.core.presentation.states.TextFieldState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val validateEmptyTextFieldUseCase: ValidateEmptyTextFieldUseCase
) : ViewModel() {


    private val _uiState = MutableStateFlow(SignInState())
    val uiState: StateFlow<SignInState> = _uiState.asStateFlow()

    fun onEvent(event: SigInEvent) {
        when (event) {
            is SigInEvent.EmailChange -> _uiState.update { state ->
                state.copy(
                    email = TextFieldState(
                        value = event.email
                    )
                )
            }

            is SigInEvent.PasswordChange -> _uiState.update { state ->
                state.copy(
                    email = TextFieldState(
                        value = event.password
                    )
                )
            }
            is SigInEvent.SignIn -> {

            }
        }
    }

}