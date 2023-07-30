package ru.asmelnikov.commerceshop.data.repository

import kotlinx.coroutines.flow.Flow
import ru.asmelnikov.commerceshop.data.datasources.CategoryDataSource
import ru.asmelnikov.commerceshop.domain.models.Category
import ru.asmelnikov.commerceshop.domain.repository.CategoryRepository

class CategoryRepositoryImpl(
    private val categoryDataSource: CategoryDataSource
) : CategoryRepository {
    override fun getCategory(): Flow<List<Category>> {
        return categoryDataSource.getCategories()
    }

}