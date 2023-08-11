package com.lglez.messenger.core.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.lglez.messenger.authentication.loading.presentation.LoadingScreen
import com.lglez.messenger.authentication.signin.presentation.SignInScreen
import com.lglez.messenger.authentication.signup.presentation.SignUpScreen
import com.lglez.messenger.authentication.welcome.presentation.WelcomeScreen
import com.lglez.messenger.home.presentation.HomeScreen

@Composable
fun Navigation(navController: NavController){
    NavHost(
        navController = navController as NavHostController,
        startDestination = Screen.LOADING,
    ){
        composable(route = Screen.LOADING){
            LoadingScreen(navController = navController)
        }

        composable(route = Screen.WELCOME){
            WelcomeScreen(navController = navController)
        }

        composable(route = Screen.SIGN_UP){
            SignUpScreen(navController = navController)
        }

        composable(route = Screen.SIGN_IN){
            SignInScreen(navController = navController)
        }

        composable(route = Screen.HOME){
            HomeScreen(navController = navController)
        }
    }
}