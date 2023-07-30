package ru.asmelnikov.commerceshop.common.navigation

sealed class CommerceShopScreenRoute(val route: String) {

    object Home : CommerceShopScreenRoute("home")
    object Cart : CommerceShopScreenRoute("cart")
    object ProductList : CommerceShopScreenRoute("product_list")
    object ProductDetail : CommerceShopScreenRoute("product_detail")

}