package com.lglez.messenger.authentication.loading.presentation

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.lglez.messenger.core.presentation.navigation.Screen
import kotlinx.coroutines.delay

@Composable
fun LoadingScreen(
    navController: NavController,
    viewModel: LoadingViewModel = hiltViewModel()
){
    val c = LocalContext.current
    LaunchedEffect(Unit){

        delay(1000)
        val hasSessionActive = viewModel.checkSession()
        navController.popBackStack()
       if (hasSessionActive){
            navController.navigate(Screen.HOME)
        } else {
            navController.navigate(Screen.WELCOME)
        }
    }


    Surface(
        color = MaterialTheme.colors.background
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            CircularProgressIndicator()
        }
    }


}