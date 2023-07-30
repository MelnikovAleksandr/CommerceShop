package ru.asmelnikov.commerceshop.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.asmelnikov.commerceshop.ui.patterns.CommerceShopBottomBar
import ru.asmelnikov.commerceshop.ui.patterns.CommerceShopTopBar
import ru.asmelnikov.commerceshop.ui.theme.CommerceShopTheme

@Composable
fun CommerceShopScreen() {
    CommerceShopTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Scaffold(
                topBar = { CommerceShopTopBar() },
                bottomBar = { CommerceShopBottomBar() }
            ) { contentPadding ->
                println(contentPadding)
            }
        }
    }
}