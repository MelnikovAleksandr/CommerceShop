package ru.asmelnikov.commerceshop.domain.usecases.cart

import kotlinx.coroutines.flow.Flow
import ru.asmelnikov.commerceshop.domain.models.CartItem
import ru.asmelnikov.commerceshop.domain.repository.CartRepository

class RemoveItemCart(
    private val repository: CartRepository
) {
    fun removeItemCart(cartItem: CartItem): Flow<List<CartItem>> {
        return repository.removeItemCart(cartItem)
    }
}