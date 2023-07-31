package ru.asmelnikov.commerceshop.data.datasources

import kotlinx.coroutines.flow.Flow
import ru.asmelnikov.commerceshop.domain.models.Category
import ru.asmelnikov.commerceshop.domain.models.Product

interface ProductDataSource {
    fun getProducts(): Flow<List<Product>>
    fun getProduct(category: Category): Flow<List<Product>>
}