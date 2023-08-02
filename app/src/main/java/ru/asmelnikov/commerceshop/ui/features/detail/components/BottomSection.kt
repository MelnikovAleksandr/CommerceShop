package ru.asmelnikov.commerceshop.ui.features.detail.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.asmelnikov.commerceshop.ui.composables.buttons.StandardButton
import ru.asmelnikov.commerceshop.R.string as AppText

@Composable
fun BottomSection(
    onBuyClicked: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        StandardButton(
            text = stringResource(AppText.add_to_cart),
            onClicked = onBuyClicked
        )
    }
}