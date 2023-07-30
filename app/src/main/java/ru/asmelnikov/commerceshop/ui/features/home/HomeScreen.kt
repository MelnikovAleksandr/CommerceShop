package ru.asmelnikov.commerceshop.ui.features.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ru.asmelnikov.commerceshop.domain.models.Category
import ru.asmelnikov.commerceshop.domain.models.Product
import ru.asmelnikov.commerceshop.ui.composables.searchbar.SearchBar
import ru.asmelnikov.commerceshop.ui.features.home.components.CategorySection
import ru.asmelnikov.commerceshop.ui.features.home.components.HomeSection
import ru.asmelnikov.commerceshop.ui.features.home.components.ProductSection
import ru.asmelnikov.commerceshop.ui.theme.LightGrayBackground
import ru.asmelnikov.commerceshop.R.string as AppText


@Composable
fun HomeScreen(
    categorySelected: (category: Category) -> Unit,
    productSelected: (product: Product) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {

    val products by viewModel.productListState.collectAsState()
    val categories by viewModel.categoryListState.collectAsState()

    HomeElements(
        categories,
        products,
        categorySelected,
        productSelected,
        modifier = modifier.background(LightGrayBackground)
    )
}

@Composable
private fun HomeElements(
    categories: List<Category>,
    products: List<Product>,
    categorySelected: (category: Category) -> Unit,
    productSelected: (product: Product) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier
            .verticalScroll(rememberScrollState())
            .padding(vertical = 16.dp)
    ) {
        SearchBar(Modifier.padding(horizontal = 16.dp))
        HomeSection(
            title = stringResource(AppText.categories),
            withArrow = false
        ) {
            CategorySection(
                categories = categories,
                categorySelected = categorySelected
            )
        }
        HomeSection(
            title = stringResource(AppText.recommended),
            withArrow = true
        ) {
            ProductSection(
                products = products,
                productSelected = productSelected
            )
        }
        HomeSection(
            title = stringResource(AppText.new_arrivals),
            withArrow = true
        ) {
            ProductSection(
                products = products,
                productSelected = productSelected
            )
        }
    }
}