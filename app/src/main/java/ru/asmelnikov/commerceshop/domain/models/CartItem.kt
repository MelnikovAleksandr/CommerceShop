package ru.asmelnikov.commerceshop.domain.models

data class CartItem(
    val quantity: Int,
    val product: Product
)