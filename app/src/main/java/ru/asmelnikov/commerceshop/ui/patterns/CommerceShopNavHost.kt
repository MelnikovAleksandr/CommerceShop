package ru.asmelnikov.commerceshop.ui.patterns

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.asmelnikov.commerceshop.common.navigation.CommerceShopScreenRoute
import ru.asmelnikov.commerceshop.common.navigation.NavigationBarSection
import ru.asmelnikov.commerceshop.common.navigation.navigateSaved
import ru.asmelnikov.commerceshop.domain.models.Category
import ru.asmelnikov.commerceshop.domain.models.Product
import ru.asmelnikov.commerceshop.domain.models.order.Order
import ru.asmelnikov.commerceshop.domain.models.order.SummaryTotals
import ru.asmelnikov.commerceshop.main.CommerceShopState
import ru.asmelnikov.commerceshop.ui.features.cart.CartScreen
import ru.asmelnikov.commerceshop.ui.features.checkout.CheckoutScreen
import ru.asmelnikov.commerceshop.ui.features.detail.ProductDetailScreen
import ru.asmelnikov.commerceshop.ui.features.home.HomeScreen
import ru.asmelnikov.commerceshop.ui.features.list.ProductListScreen
import ru.asmelnikov.commerceshop.ui.features.payment.PlaceOrderScreen

@Composable
fun CommerceShopNavHost(appState: CommerceShopState, paddingValues: PaddingValues) {
    NavHost(
        navController = appState.navController,
        startDestination = NavigationBarSection.Home.route,
        modifier = Modifier.padding(paddingValues)
    ) {
        appSoGraph(appState)
    }
}

fun NavGraphBuilder.appSoGraph(appState: CommerceShopState) {

    val homeRoute = CommerceShopScreenRoute.Home.route
    val listRoute = CommerceShopScreenRoute.ProductList.route
    val detailRoute = CommerceShopScreenRoute.ProductDetail.route
    val cartRoute = CommerceShopScreenRoute.Cart.route
    val checkout = CommerceShopScreenRoute.Checkout.route
    val placeOrder = CommerceShopScreenRoute.PlaceOrder.route


    val productSelectedInHome: (Product) -> Unit = { product: Product ->
        appState.productSelected = product
        appState.navigateSaved(detailRoute, homeRoute)
    }
    val categorySelectedInHome: (Category) -> Unit = { category: Category ->
        appState.categorySelected = category
        appState.navigateSaved(listRoute, homeRoute)
    }

    val productSelectedInList: (Product) -> Unit = { product: Product ->
        appState.productSelected = product
        appState.navigateSaved(detailRoute, listRoute)
    }

    val goToCartScreen: () -> Unit = {
        appState.navigateSaved(cartRoute, detailRoute)
    }

    val goToCheckoutScreen: (SummaryTotals) -> Unit = { summary ->
        appState.summaryTotals = summary
        appState.navigateSaved(checkout, cartRoute)
    }

    val goToPlaceOrderScreen: (Order) -> Unit = { order ->
        appState.orderSelected = order
        appState.navigateSaved(placeOrder, checkout)
    }

    composable(NavigationBarSection.Home.route) {
        HomeScreen(
            categorySelected = categorySelectedInHome,
            productSelected = productSelectedInHome
        )
    }

    composable(NavigationBarSection.Cart.route) {
        CartScreen(
            goToCheckout = goToCheckoutScreen
        )
    }

    composable(CommerceShopScreenRoute.ProductList.route) {
        ProductListScreen(
            category = appState.categorySelected,
            productSelected = productSelectedInList
        )
    }

    composable(CommerceShopScreenRoute.ProductDetail.route) {
        ProductDetailScreen(
            product = appState.productSelected,
            goToCart = goToCartScreen
        )
    }

    composable(CommerceShopScreenRoute.Checkout.route) {
        CheckoutScreen(
            summary = appState.summaryTotals,
            goToPlaceOrder = goToPlaceOrderScreen
        )
    }

    composable(CommerceShopScreenRoute.PlaceOrder.route) {
        PlaceOrderScreen(order = appState.orderSelected)
    }
}