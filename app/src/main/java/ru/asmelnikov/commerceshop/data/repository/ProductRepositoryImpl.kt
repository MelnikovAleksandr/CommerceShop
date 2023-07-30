package ru.asmelnikov.commerceshop.data.repository

import kotlinx.coroutines.flow.Flow
import ru.asmelnikov.commerceshop.data.datasources.ProductDataSource
import ru.asmelnikov.commerceshop.domain.models.Category
import ru.asmelnikov.commerceshop.domain.models.Product
import ru.asmelnikov.commerceshop.domain.repository.ProductRepository

class ProductRepositoryImpl(
    private val productDataSource: ProductDataSource
) : ProductRepository {
    override fun getProducts(): Flow<List<Product>> {
        return productDataSource.getProducts()
    }

    override fun getProduct(category: Category): Flow<List<Product>> {
        return productDataSource.getProduct(category)
    }
}