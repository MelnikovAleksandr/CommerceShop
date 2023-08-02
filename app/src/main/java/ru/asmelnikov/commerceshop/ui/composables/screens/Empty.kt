package ru.asmelnikov.commerceshop.ui.composables.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.foundation.Image
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.asmelnikov.commerceshop.R
import ru.asmelnikov.commerceshop.ui.theme.LightGrey
import ru.asmelnikov.commerceshop.ui.theme.Orange

@Composable
fun Empty(
    userMessage: String
) {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(R.drawable.ic_baseline_shopping_cart_24),
            contentDescription = null,
            modifier = Modifier.size(100.dp),
            colorFilter = ColorFilter.tint(color = LightGrey)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = userMessage,
            style = MaterialTheme.typography.subtitle1,
            color = Orange
        )
    }
}