package ru.asmelnikov.commerceshop.domain.usecases.cart

import kotlinx.coroutines.flow.Flow
import ru.asmelnikov.commerceshop.domain.models.CartItem
import ru.asmelnikov.commerceshop.domain.repository.CartRepository

class UpdateCartItems(
    private val repository: CartRepository
) {
    fun updateCartItems(cartItems: CartItem, operator: Int): Flow<List<CartItem>> {
        return repository.updateCartItems(cartItems, operator)
    }
}