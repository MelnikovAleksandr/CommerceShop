package ru.asmelnikov.commerceshop.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.asmelnikov.commerceshop.ui.patterns.CommerceShopBottomBar
import ru.asmelnikov.commerceshop.ui.patterns.CommerceShopNavHost
import ru.asmelnikov.commerceshop.ui.patterns.CommerceShopTopBar
import ru.asmelnikov.commerceshop.ui.theme.CommerceShopTheme

@Composable
fun CommerceShopScreen() {
    CommerceShopTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            val appState = rememberAppState()
            Scaffold(
                scaffoldState = appState.scaffoldState,
                topBar = { CommerceShopTopBar() },
                bottomBar = {
                    CommerceShopBottomBar(
                        navController = appState.navController
                    )
                }
            ) { contentPadding ->
                CommerceShopNavHost(appState = appState, paddingValues = contentPadding)
            }
        }
    }
}