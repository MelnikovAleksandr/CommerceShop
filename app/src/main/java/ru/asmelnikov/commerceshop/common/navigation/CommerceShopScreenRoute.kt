package ru.asmelnikov.commerceshop.common.navigation

sealed class CommerceShopScreenRoute(val route: String) {

    companion object {
        val withArrowBack = listOf(
            ProductDetail,
            Checkout,
            PlaceOrder
        )
    }

    object Home : CommerceShopScreenRoute("home")
    object Cart : CommerceShopScreenRoute("cart")
    object ProductList : CommerceShopScreenRoute("product_list")
    object ProductDetail : CommerceShopScreenRoute("product_detail")
    object Checkout : CommerceShopScreenRoute("checkout")
    object PlaceOrder : CommerceShopScreenRoute("place_order")

}