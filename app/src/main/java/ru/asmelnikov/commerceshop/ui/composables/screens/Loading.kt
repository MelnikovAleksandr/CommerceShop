package ru.asmelnikov.commerceshop.ui.composables.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.asmelnikov.commerceshop.ui.theme.LightGrayBackground
import ru.asmelnikov.commerceshop.ui.theme.Orange

@Composable
fun Loading(

) {
    Column(
        Modifier.fillMaxSize().background(LightGrayBackground),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(50.dp),
            color = Orange,
            strokeWidth = 5.dp
        )
    }
}