package ru.asmelnikov.commerceshop.ui.composables.cards

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import ru.asmelnikov.commerceshop.R
import ru.asmelnikov.commerceshop.domain.models.Product
import ru.asmelnikov.commerceshop.ui.theme.Orange
import ru.asmelnikov.commerceshop.ui.theme.TitleTextColor

@Composable
fun ProductCard(
    product: Product,
    productSelected: (product: Product) -> Unit
) {
    Card(
        modifier = Modifier
            .width(180.dp)
            .wrapContentHeight(),
        shape = RoundedCornerShape(24.dp),
        elevation = 4.dp
    ) {

        Column(
            modifier = Modifier
                .clickable { productSelected(product) }
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(8.dp)
        ) {
            IconButton(
                onClick = { },
                modifier = Modifier.align(Alignment.End)
            ) {
                Icon(
                    imageVector = Icons.Outlined.FavoriteBorder,
                    contentDescription = "",
                    tint = Orange
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(product.urlImage)
                        .crossfade(true)
                        .build(),
                    placeholder = painterResource(R.drawable.placeholder_product),
                    contentDescription = "",
                    modifier = Modifier.size(100.dp),
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Text(
                    text = product.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = TitleTextColor
                )

                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                Orange,
                                fontWeight = FontWeight.Bold
                            )
                        ) {
                            append("$ " + product.price)
                        }
                    },
                    style = MaterialTheme.typography.subtitle1,
                    modifier = Modifier,
                    fontSize = 16.sp
                )
            }
        }
    }
}