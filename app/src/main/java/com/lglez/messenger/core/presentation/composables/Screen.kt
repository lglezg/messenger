package com.lglez.messenger.core.presentation.composables

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable

@Composable
fun Screen(
    topBar : @Composable () -> Unit = {},
    content: @Composable (PaddingValues) -> Unit
){
    Scaffold(
        topBar =  topBar
    ) {
        content(it)
    }
}