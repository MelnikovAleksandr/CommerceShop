package ru.asmelnikov.commerceshop.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.asmelnikov.commerceshop.domain.models.CartItem

interface CartRepository {
    fun saveItemCart(cartItem: CartItem): Flow<List<CartItem>>
    fun removeItemCart(cartItem: CartItem): Flow<List<CartItem>>
    fun getCartItems(): Flow<List<CartItem>>
    fun updateCartItems(cartItem: CartItem, operator: Int): Flow<List<CartItem>>
}