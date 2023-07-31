package ru.asmelnikov.commerceshop.data.datasources.mock

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import ru.asmelnikov.commerceshop.data.datasources.ProductDataSource
import ru.asmelnikov.commerceshop.domain.models.Category
import ru.asmelnikov.commerceshop.domain.models.Product

class ProductMocked : ProductDataSource {

    val products: List<Product> =
        listOf(
            DataMocked.product1,
            DataMocked.product2,
            DataMocked.product3,
            DataMocked.product4,
            DataMocked.product5,
            DataMocked.product6,
            DataMocked.product7,
            DataMocked.product8,
            DataMocked.product9,
            DataMocked.product10,
            DataMocked.product11,
            DataMocked.product12,
            DataMocked.product13,
            DataMocked.product14,
            DataMocked.product15
        )

    override fun getProducts(): Flow<List<Product>> {
        return flowOf(products)
    }

    override fun getProduct(category: Category): Flow<List<Product>> {
        return flowOf(products.filter { it.category.id == category.id })
    }
}