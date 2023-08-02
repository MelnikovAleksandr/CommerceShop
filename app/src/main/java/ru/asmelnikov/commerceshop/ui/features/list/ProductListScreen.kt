package ru.asmelnikov.commerceshop.ui.features.list

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import ru.asmelnikov.commerceshop.domain.models.Category
import ru.asmelnikov.commerceshop.domain.models.Product
import ru.asmelnikov.commerceshop.ui.features.list.components.ProductListItem
import ru.asmelnikov.commerceshop.ui.theme.LightGrayBackground


@Composable
fun ProductListScreen(
    category: Category,
    productSelected: (Product) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: ProductListViewModel = hiltViewModel()
) {
    val products by viewModel.productListState(category).collectAsState()

    ProductListContent(
        products,
        productSelected,
        modifier = modifier.background(LightGrayBackground)
    )
}

@Composable
fun ProductListContent(
    products: List<Product>,
    productSelected: (Product) -> Unit,
    modifier: Modifier = Modifier
) {
    ProductListItem(
        products = products,
        productSelected = productSelected,
        modifier = modifier
    )
}