package com.lglez.messenger.core.presentation.composables

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun RoundedTopBar(
    @StringRes title: Int,
    navigation: @Composable (() -> Unit)? = null,
    actions: @Composable () -> Unit = {}
) {
    TopAppBar(
        modifier = Modifier.clip(RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp)),
        title = { Text(text = stringResource(id = title)) },
        backgroundColor = MaterialTheme.colors.primary,
        navigationIcon = navigation,
        actions = { actions() },
        elevation = 10.dp
    )
}

@Composable
fun TopBarAction(
    @DrawableRes icon: Int,
    onClick: () -> Unit
) {
    IconButton(onClick = onClick) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null
        )
    }
}