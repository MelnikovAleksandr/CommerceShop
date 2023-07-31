package ru.asmelnikov.commerceshop.data.datasources

import kotlinx.coroutines.flow.Flow
import ru.asmelnikov.commerceshop.domain.models.Category

interface CategoryDataSource {
    fun getCategories() : Flow<List<Category>>
}