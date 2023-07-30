package ru.asmelnikov.commerceshop.main

import android.content.res.Resources
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope
import ru.asmelnikov.commerceshop.common.navigation.CommerceShopScreenRoute
import ru.asmelnikov.commerceshop.domain.models.Category
import ru.asmelnikov.commerceshop.domain.models.Product
import ru.asmelnikov.commerceshop.domain.models.order.Order
import ru.asmelnikov.commerceshop.domain.models.order.SummaryTotals

@Composable
fun rememberAppState(
    scaffold: ScaffoldState = rememberScaffoldState(),
    navController: NavHostController = rememberNavController(),
    resources: Resources = resources(),
    coroutineScope: CoroutineScope = rememberCoroutineScope()
) = remember(
    scaffold,
    navController,
    resources,
    coroutineScope
) {
    CommerceShopState(
        scaffold, navController, resources, coroutineScope
    )
}

class CommerceShopState(
    val scaffoldState: ScaffoldState,
    val navController: NavHostController,
    private val resources: Resources,
    coroutineScope: CoroutineScope
){
    private val screensWithArrowBack = CommerceShopScreenRoute.withArrowBack.map { it.route }

    val shouldShowArrowBack: Boolean
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination?.route in screensWithArrowBack

    lateinit var categorySelected: Category
    lateinit var productSelected: Product
    lateinit var summaryTotals: SummaryTotals
    lateinit var orderSelected: Order
}

@Composable
@ReadOnlyComposable
fun resources(): Resources {
    LocalConfiguration.current
    return LocalContext.current.resources
}