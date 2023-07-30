package ru.asmelnikov.commerceshop.domain.usecases.product

import kotlinx.coroutines.flow.Flow
import ru.asmelnikov.commerceshop.domain.models.Category
import ru.asmelnikov.commerceshop.domain.models.Product
import ru.asmelnikov.commerceshop.domain.repository.ProductRepository

class GetProductDetail(
    private val repository: ProductRepository
) {
    fun getProducts(category: Category): Flow<List<Product>> {
        return repository.getProduct(category)
    }
}