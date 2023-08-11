package com.lglez.messenger.authentication.signin.presentation

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
fun SignInScreen(
    navController: NavController,
    viewModel: SignInViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    Scaffold() {
        SignInForm(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            uiState = uiState
        ){event ->
            viewModel.onEvent(event)
        }
    }
}

@Composable
fun SignInForm(
    modifier: Modifier,
    uiState : SignInState,
    onEvent : (SigInEvent) -> Unit
) {
    
    val currentFocus = LocalFocusManager.current
    Box(
        modifier = modifier
        .verticalScroll(rememberScrollState())
    )
    Column(
       modifier = Modifier
           .fillMaxWidth()
           .padding(horizontal = 30.dp)

    ) {
        
        Text(
            modifier = Modifier
                .padding(top = 100.dp, bottom = 50.dp)
                .align(CenterHorizontally),
            text = stringResource(id = R.string.signin_label),
            style = MaterialTheme.typography.subtitle1
        )


        TextFieldElevated(
            modifier = Modifier
                .padding(bottom = 10.dp)
                .fillMaxWidth(),
            value = uiState.email.value,
            onValueChange = { onEvent(SigInEvent.EmailChange(it)) },
            label = { Text(text = stringResource(id = R.string.email_label)) },
            placeholder = { Text(text = stringResource(id = R.string.email_placeholder)) },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { currentFocus.moveFocus(FocusDirection.Down) }
            )
        )
        
        TextFieldElevated(
            modifier = Modifier
                .padding(bottom = 50.dp)
                .fillMaxWidth(),
            value = uiState.password.value,
            onValueChange = { onEvent(SigInEvent.PasswordChange(it)) },
            label = { Text(text = stringResource(id = R.string.password_label)) },
            placeholder = { Text(text = stringResource(id = R.string.password_placeholder)) },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone  = { currentFocus.clearFocus() }
            )
        )
        
        RoundedButton(
            modifier = Modifier.fillMaxWidth(),
            content = { Text(text = stringResource(id = R.string.signin_label)) }
        ) {
            onEvent(SigInEvent.SignIn)
        }
        

    }
}
