package ru.asmelnikov.commerceshop.domain.usecases.cart

import kotlinx.coroutines.flow.Flow
import ru.asmelnikov.commerceshop.domain.models.CartItem
import ru.asmelnikov.commerceshop.domain.repository.CartRepository

class GetCartItems(
    private val repository: CartRepository
) {

    fun getCartItems(): Flow<List<CartItem>> {
        return repository.getCartItems()
    }
}