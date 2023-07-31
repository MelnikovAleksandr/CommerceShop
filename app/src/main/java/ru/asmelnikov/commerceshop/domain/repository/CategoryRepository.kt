package ru.asmelnikov.commerceshop.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.asmelnikov.commerceshop.domain.models.Category

interface CategoryRepository {
    fun getCategory(): Flow<List<Category>>
}