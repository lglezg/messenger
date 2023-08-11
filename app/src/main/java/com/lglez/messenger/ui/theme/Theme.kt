package com.lglez.messenger.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorPalette = darkColors(
    primary = Blue30,
    onPrimary = Blue90,
    secondary = Yellow30,
    onSecondary = Yellow90,
    error = Red30,
    onError = Red90,
    background = Tundra10,
    onBackground = Tundra90,
    surface = Tundra20,
    onSurface = Tundra90
)

private val LightColorPalette = lightColors(
    primary = Blue50,
    onPrimary = White,
    secondary = Yellow50,
    onSecondary = White,
    error = Red50,
    onError = White,
    background = White,
    onBackground = Tundra10,
    surface = White,
    onSurface = Tundra20

)

@Composable
fun MessengerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colors.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        content = content
    )
}