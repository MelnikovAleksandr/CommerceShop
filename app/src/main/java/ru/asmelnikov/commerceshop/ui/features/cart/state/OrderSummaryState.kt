package ru.asmelnikov.commerceshop.ui.features.cart.state

import ru.asmelnikov.commerceshop.domain.models.CartItem

data class OrderSummaryState(
    val cartItems: List<CartItem> = emptyList(),
    val shipping: Double = 0.00,
    val tax: Double = 0.00
)

val OrderSummaryState.itemsTotal: Double
    get() =
        cartItems
            .map { item -> item.product.price * item.quantity }
            .fold(0.0) { total, next -> total + next }

val OrderSummaryState.allTotal: Double
    get() = itemsTotal + shipping + tax