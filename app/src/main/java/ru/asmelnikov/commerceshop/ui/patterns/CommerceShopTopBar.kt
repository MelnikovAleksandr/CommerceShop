package ru.asmelnikov.commerceshop.ui.patterns

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import ru.asmelnikov.commerceshop.R
import ru.asmelnikov.commerceshop.common.navigation.popUp
import ru.asmelnikov.commerceshop.main.CommerceShopState

@Composable
fun CommerceShopTopBar(appState: CommerceShopState) {
    if (appState.shouldShowArrowBack) {
        TopAppBarWithArrow(
            title = stringResource(id = R.string.app_name),
            goBack = { appState.popUp() }
        )
    } else {
        TopAppBarWithoutArrow(
            title = stringResource(id = R.string.app_name)
        )
    }
}

@Composable
fun TopAppBarWithoutArrow(
    title: String,
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        },
        backgroundColor = MaterialTheme.colors.background,
        contentColor = contentColorFor(MaterialTheme.colors.background)
    )
}

@Composable
fun TopAppBarWithArrow(
    title: String,
    goBack: () -> Unit,
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth()
            )
        },
        backgroundColor = MaterialTheme.colors.background,
        contentColor = contentColorFor(MaterialTheme.colors.background),
        navigationIcon = {
            IconButton(onClick = goBack) {
                Icon(Icons.Filled.ArrowBack, "BackIcon")
            }

        })
}