package ru.asmelnikov.commerceshop.ui.features.cart.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.asmelnikov.commerceshop.ui.composables.summary.Summary
import ru.asmelnikov.commerceshop.ui.theme.LightGrey

@Composable
fun CartSummary(
    numberItems: Int,
    totalItems: Double,
    shippingCost: Double,
    taxCost: Double,
    total: Double
) {

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Divider(color = LightGrey, thickness = 2.dp)
        Spacer(modifier = Modifier.padding(8.dp))
        Summary(
            numberItems = numberItems,
            totalItems = totalItems,
            shippingCost = shippingCost,
            taxCost = taxCost,
            total = total
        )
    }
}
