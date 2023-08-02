package ru.asmelnikov.commerceshop.ui.features.list.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.asmelnikov.commerceshop.domain.models.Product
import ru.asmelnikov.commerceshop.ui.composables.items.ProductItem

@Composable
fun ProductListItem(
    products: List<Product>,
    productSelected: (Product) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(products, key = { it.id }) {
            ProductItem(it, productSelected)
        }
    }

}