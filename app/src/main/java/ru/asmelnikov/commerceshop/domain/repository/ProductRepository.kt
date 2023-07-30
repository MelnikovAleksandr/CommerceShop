package ru.asmelnikov.commerceshop.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.asmelnikov.commerceshop.domain.models.Category
import ru.asmelnikov.commerceshop.domain.models.Product

interface ProductRepository {
    fun getProducts(): Flow<List<Product>>
    fun getProduct(category: Category): Flow<List<Product>>
}