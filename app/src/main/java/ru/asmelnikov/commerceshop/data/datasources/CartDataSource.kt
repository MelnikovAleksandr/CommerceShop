package ru.asmelnikov.commerceshop.data.datasources

import kotlinx.coroutines.flow.Flow
import ru.asmelnikov.commerceshop.domain.models.CartItem

interface CartDataSource {
    fun getCartItems(): Flow<List<CartItem>>
    fun saveItemCart(cartItem: CartItem): Flow<List<CartItem>>
    fun removeItemCart(cartItem: CartItem): Flow<List<CartItem>>
    fun updateCartItems(cartItem: CartItem, operator: Int): Flow<List<CartItem>>
}