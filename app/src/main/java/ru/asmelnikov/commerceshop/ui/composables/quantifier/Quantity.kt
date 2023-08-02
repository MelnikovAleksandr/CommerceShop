package ru.asmelnikov.commerceshop.ui.composables.quantifier

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.asmelnikov.commerceshop.ui.theme.*
import ru.asmelnikov.commerceshop.R

@Composable
fun Quantity(
    count: Int,
    decreaseItemCount: () -> Unit,
    increaseItemCount: () -> Unit,
    price: Double
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        QuantitySelector(
            count = count,
            decreaseItemCount = decreaseItemCount,
            increaseItemCount = increaseItemCount
        )

        PriceView(price)
    }
}

@Composable
fun QuantitySelector(
    count: Int,
    decreaseItemCount: () -> Unit,
    increaseItemCount: () -> Unit,
) {
    Box(
        modifier = Modifier
            .wrapContentHeight()
    ) {
        Row(
            modifier = Modifier
                .padding(1.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = decreaseItemCount) {
                Icon(
                    painter = painterResource(id = R.drawable.minus),
                    contentDescription = null,
                    tint = LightBlack
                )
            }
            Text(
                text = "$count",
                color = LightBlack,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )

            IconButton(onClick = increaseItemCount) {
                Icon(
                    painter = painterResource(id = R.drawable.plus),
                    contentDescription = null,
                    tint = LightBlack
                )
            }
        }
    }
}


@Composable
fun PriceView(price: Double) {
    Text(
        text = "$ $price",
        color = Orange,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold
    )
}