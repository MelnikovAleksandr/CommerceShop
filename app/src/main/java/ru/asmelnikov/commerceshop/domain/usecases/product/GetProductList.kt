package ru.asmelnikov.commerceshop.domain.usecases.product

import kotlinx.coroutines.flow.Flow
import ru.asmelnikov.commerceshop.domain.models.Product
import ru.asmelnikov.commerceshop.domain.repository.ProductRepository

class GetProductList(private val repository: ProductRepository) {
    fun getProducts(): Flow<List<Product>> {
        return repository.getProducts()
    }
}