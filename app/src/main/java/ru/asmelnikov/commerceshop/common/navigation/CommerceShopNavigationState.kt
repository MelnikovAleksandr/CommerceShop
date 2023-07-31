package ru.asmelnikov.commerceshop.common.navigation

import ru.asmelnikov.commerceshop.main.CommerceShopState

fun CommerceShopState.popUp() {
    navController.popBackStack()
}

fun CommerceShopState.navigate(route: String) {
    navController.navigate(route) {
        launchSingleTop = true
    }
}

fun CommerceShopState.navigateAndPopUp(route: String, popUp: String) {
    navController.navigate(route) {
        launchSingleTop = true
        popUpTo(popUp) { inclusive = true }
    }
}

fun CommerceShopState.navigateSaved(route: String, popUp: String) {
    navController.navigate(route) {
        launchSingleTop = true
        restoreState = true
        popUpTo(popUp) { saveState = true }
    }
}

fun CommerceShopState.clearAndNavigate(route: String) {
    navController.navigate(route) {
        launchSingleTop = true
        popUpTo(0) { inclusive = true }
    }
}