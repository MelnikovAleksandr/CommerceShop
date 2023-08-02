package ru.asmelnikov.commerceshop.ui.features.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ru.asmelnikov.commerceshop.domain.models.Product
import ru.asmelnikov.commerceshop.ui.features.detail.components.BodyDetail
import ru.asmelnikov.commerceshop.ui.theme.LightGrayBackground
import ru.asmelnikov.commerceshop.ui.theme.Orange
import ru.asmelnikov.commerceshop.R.string as AppText

@Composable
fun ProductDetailScreen(
    product: Product,
    goToCart: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: ProductDetailViewModel = hiltViewModel(),
) {
    BodyDetail(
        product = product,
        addToCart = { count -> viewModel.saveItemCart(product, count) },
        showAlert = viewModel.showAlert,
        onGoToCart = goToCart,
        onPopupDismissed = viewModel.onPopupDismissed(),
        modifier = modifier
            .fillMaxSize()
            .background(LightGrayBackground)
    )
}