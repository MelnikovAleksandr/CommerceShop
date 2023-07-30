package ru.asmelnikov.commerceshop.data.datasources.mock

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import ru.asmelnikov.commerceshop.data.datasources.CategoryDataSource
import ru.asmelnikov.commerceshop.domain.models.Category

class CategoryMocked : CategoryDataSource {

    override fun getCategories(): Flow<List<Category>> {
        val categories: List<Category> =
            listOf(
                DataMocked.category1,
                DataMocked.category2,
                DataMocked.category3,
                DataMocked.category4
            )
        return flowOf(categories)
    }
}