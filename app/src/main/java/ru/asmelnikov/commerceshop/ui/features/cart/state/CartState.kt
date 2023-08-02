package ru.asmelnikov.commerceshop.ui.features.cart.state

import ru.asmelnikov.commerceshop.domain.models.CartItem

data class CartState(
    val cartItems: List<CartItem> = emptyList()
)

val CartState.readyForCheckOut: Boolean
    get() = cartItems.isNotEmpty()
