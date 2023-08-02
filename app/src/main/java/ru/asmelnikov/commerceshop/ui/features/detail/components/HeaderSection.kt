package ru.asmelnikov.commerceshop.ui.features.detail.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.asmelnikov.commerceshop.domain.models.Product
import ru.asmelnikov.commerceshop.ui.theme.*


@Composable
fun HeaderSection(product: Product) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Divider(
            color = White,
            modifier = Modifier
                .height(5.dp)
                .width(30.dp)
        )
    }

    Column(
        modifier = Modifier.padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = product.category.name,
            fontSize = 16.sp,
            color = Color.Gray,
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = product.name,
            fontSize = 24.sp,
            color = LightBlack,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        TitleTextColor
                    )
                ) {
                    append("$ " + product.price + "/per item")
                }
            },
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier,
            fontSize = 16.sp

        )
        Spacer(modifier = Modifier.height(4.dp))
        product.description?.let {
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = it,
                fontSize = 18.sp,
                color = Color.Gray
            )
        }
    }
}