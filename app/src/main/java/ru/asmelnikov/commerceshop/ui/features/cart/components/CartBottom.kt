package ru.asmelnikov.commerceshop.ui.features.cart.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import ru.asmelnikov.commerceshop.ui.composables.buttons.StandardButton
import ru.asmelnikov.commerceshop.R.string as AppText

@Composable
fun CartBottom(
    checkoutSelected: () -> Unit,
    checkoutReady: Boolean
) {
    StandardButton(
        text = stringResource(id = AppText.checkout),
        onClicked = checkoutSelected,
        enabled = checkoutReady
    )
}