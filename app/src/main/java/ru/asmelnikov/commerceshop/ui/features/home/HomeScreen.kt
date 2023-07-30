package ru.asmelnikov.commerceshop.ui.features.home

import androidx.compose.material.BottomAppBar
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {
    Scaffold(
        topBar = {
            TopAppBar {

            }
        },
        bottomBar = {
            BottomAppBar {

            }
        }
    ) { contentPadding ->

    }
}