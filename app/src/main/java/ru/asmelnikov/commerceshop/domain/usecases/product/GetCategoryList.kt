package ru.asmelnikov.commerceshop.domain.usecases.product

import kotlinx.coroutines.flow.Flow
import ru.asmelnikov.commerceshop.domain.models.Category
import ru.asmelnikov.commerceshop.domain.repository.CategoryRepository

class GetCategoryList(private val repository: CategoryRepository) {
    fun getCategories() : Flow<List<Category>> {
        return repository.getCategory()
    }
}