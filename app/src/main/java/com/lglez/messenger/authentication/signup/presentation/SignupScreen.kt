package com.lglez.messenger.authentication.signup.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.lglez.messenger.R
import com.lglez.messenger.core.presentation.composables.RoundedButton
import com.lglez.messenger.core.presentation.composables.TextFieldElevated

@Composable
fun SignUpScreen(
    navController: NavController,
    viewModel: SignUpViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    Scaffold() {
        SignUpForm(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            uiState = uiState
        ){ event ->
            viewModel.onEvent(event)
        }
    }
}

@Composable
fun SignUpForm(
    modifier: Modifier,
    uiState : SignupState,
    onEvent : (SignUpEvent) -> Unit
) {
    
    val currentFocus = LocalFocusManager.current
    Box(
        modifier = modifier
        .verticalScroll(rememberScrollState())
    ){

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)

        ) {

            Text(
                modifier = Modifier
                    .padding(top = 100.dp, bottom = 50.dp)
                    .align(CenterHorizontally),
                text = stringResource(id = R.string.signup_label),
                style = MaterialTheme.typography.subtitle1
            )

            TextFieldElevated(
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .fillMaxWidth(),
                value = uiState.name.value,
                onValueChange = { onEvent(SignUpEvent.NameChange(it)) },
                label = { Text(text = stringResource(id = R.string.name_label)) },
                placeholder = { Text(text = stringResource(id = R.string.name_placeholder)) },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = { currentFocus.moveFocus(FocusDirection.Down) }
                ),
                errorMessage = uiState.name.onError
            )
            TextFieldElevated(
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .fillMaxWidth(),
                value = uiState.email.value,
                onValueChange = { onEvent(SignUpEvent.EmailChange(it)) },
                label = { Text(text = stringResource(id = R.string.email_label)) },
                placeholder = { Text(text = stringResource(id = R.string.email_placeholder)) },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = { currentFocus.moveFocus(FocusDirection.Down) }
                ),
                errorMessage = uiState.email.onError
            )

            TextFieldElevated(
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .fillMaxWidth(),
                value = uiState.password.value,
                onValueChange = { onEvent(SignUpEvent.PasswordChange(it)) },
                label = { Text(text = stringResource(id = R.string.password_label)) },
                placeholder = { Text(text = stringResource(id = R.string.password_placeholder)) },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = { currentFocus.moveFocus(FocusDirection.Down) }
                ),
                errorMessage = uiState.password.onError
            )

            TextFieldElevated(
                modifier = Modifier
                    .padding(bottom = 50.dp)
                    .fillMaxWidth(),
                value = uiState.confirmPassword.value,
                onValueChange = { onEvent(SignUpEvent.ConfirmPasswordChange(it)) },
                label = { Text(text = stringResource(id = R.string.confirm_password_label)) },
                placeholder = { Text(text = stringResource(id = R.string.password_placeholder)) },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = { currentFocus.clearFocus() }
                ),
                errorMessage = uiState.confirmPassword.onError
            )

            RoundedButton(
                modifier = Modifier.fillMaxWidth(),
                content = { Text(text = stringResource(id = R.string.finish_label)) }
            ) {

            }


        }
    }
}
