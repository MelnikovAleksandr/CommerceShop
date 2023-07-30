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
import ru.asmelnikov.commerceshop.main.CommerceShopState
import ru.asmelnikov.commerceshop.ui.features.cart.CartScreen
import ru.asmelnikov.commerceshop.ui.features.detail.ProductDetailScreen
import ru.asmelnikov.commerceshop.ui.features.home.HomeScreen
import ru.asmelnikov.commerceshop.ui.features.list.ProductListScreen

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

    composable(NavigationBarSection.Home.route) {
        HomeScreen()
    }

    composable(NavigationBarSection.Cart.route) {
        CartScreen()
    }

    composable(CommerceShopScreenRoute.ProductList.route) {
        ProductListScreen()
    }

    composable(CommerceShopScreenRoute.ProductDetail.route) {
        ProductDetailScreen()
    }

}