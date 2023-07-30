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
import ru.asmelnikov.commerceshop.common.navigation.popUp
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

    val homeRoute = CommerceShopScreenRoute.Home.route
    val listRoute = CommerceShopScreenRoute.ProductList.route
    val detailRoute = CommerceShopScreenRoute.ProductDetail.route


    val goToListFromHome: () -> Unit = {
        appState.navigateSaved(listRoute, homeRoute)
    }

    val goToDetailFromList: () -> Unit = {
        appState.navigateSaved(detailRoute, listRoute)
    }

    val goBack: () -> Unit = {
        appState.popUp()
    }

    composable(NavigationBarSection.Home.route) {
        HomeScreen(goToProductList = goToListFromHome)
    }

    composable(NavigationBarSection.Cart.route) {
        CartScreen()
    }

    composable(CommerceShopScreenRoute.ProductList.route) {
        ProductListScreen(goToProductDetail = goToDetailFromList)
    }

    composable(CommerceShopScreenRoute.ProductDetail.route) {
        ProductDetailScreen(goToBack = goBack)
    }

}