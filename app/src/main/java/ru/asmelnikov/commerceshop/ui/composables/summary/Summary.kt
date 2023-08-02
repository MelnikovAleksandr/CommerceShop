package ru.asmelnikov.commerceshop.ui.composables.summary

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.asmelnikov.commerceshop.ui.theme.LightBlack
import ru.asmelnikov.commerceshop.ui.theme.TitleTextColor

@Composable
fun Summary(
    numberItems: Int,
    totalItems: Double,
    shippingCost: Double,
    taxCost: Double,
    total: Double
) {
    Column(
        modifier = Modifier.padding(10.dp)
    ) {
        SummaryText(
            label = "Items($numberItems):",
            value = "$ $totalItems"
        )
        SummaryText(
            label = "Shipping:",
            value = "$ $shippingCost"
        )
        SummaryText(
            label = "Tax:",
            value = "$ $taxCost"
        )
        SummaryText(
            label = "Total:",
            value = "$ $total",
            fontSizeLabel = 16.sp,
            fontSizeValue = 18.sp
        )
    }
}

@Composable
fun SummaryText(
    label: String,
    value: String,
    fontSizeLabel: TextUnit = 14.sp,
    fontSizeValue: TextUnit = 16.sp,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            fontSize = fontSizeLabel,
            color = LightBlack
        )

        Text(
            text = value,
            fontSize = fontSizeValue,
            color = TitleTextColor,
            fontWeight = FontWeight.Bold
        )
    }
}