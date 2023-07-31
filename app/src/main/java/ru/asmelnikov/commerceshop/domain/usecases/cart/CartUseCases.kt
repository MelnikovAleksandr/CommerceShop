package ru.asmelnikov.commerceshop.domain.usecases.cart

data class CartUseCases (
    val saveItemCart: SaveItemCart,
    val removeItemCart: RemoveItemCart,
    val getCartItems: GetCartItems,
    val updateCartItems: UpdateCartItems
)