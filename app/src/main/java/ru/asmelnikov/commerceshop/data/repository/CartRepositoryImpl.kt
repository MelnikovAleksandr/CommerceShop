package ru.asmelnikov.commerceshop.data.repository

import kotlinx.coroutines.flow.Flow
import ru.asmelnikov.commerceshop.data.datasources.CartDataSource
import ru.asmelnikov.commerceshop.domain.models.CartItem
import ru.asmelnikov.commerceshop.domain.repository.CartRepository

class CartRepositoryImpl(
    private val cartDataSource: CartDataSource
): CartRepository {
    override fun saveItemCart(cartItem: CartItem): Flow<List<CartItem>> {
        return cartDataSource.saveItemCart(cartItem)
    }

    override fun removeItemCart(cartItem: CartItem): Flow<List<CartItem>> {
        return cartDataSource.removeItemCart(cartItem)
    }

    override fun getCartItems(): Flow<List<CartItem>> {
        return cartDataSource.getCartItems()
    }

    override fun updateCartItems(cartItem: CartItem, operator: Int): Flow<List<CartItem>> {
        return cartDataSource.updateCartItems(cartItem, operator)
    }
}