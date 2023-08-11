package com.lglez.messenger.core.presentation.composables

import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun RoundedButton(
    modifier: Modifier,
    background: Color = MaterialTheme.colors.primary,
    content: @Composable () -> Unit,
    onClick: () ->Unit
){
    Button(
        modifier = modifier
            .heightIn(50.dp),
        shape = RoundedCornerShape(25.dp),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = background
        ),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 10.dp
        )
    ) {
        content()
    }
}