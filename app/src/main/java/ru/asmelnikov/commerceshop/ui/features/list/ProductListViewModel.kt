package ru.asmelnikov.commerceshop.ui.features.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import ru.asmelnikov.commerceshop.domain.models.Category
import ru.asmelnikov.commerceshop.domain.usecases.product.ProductUseCases
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    private val productUseCases: ProductUseCases
) : ViewModel() {

    val productListState = { category: Category ->
        productUseCases.getProduct.getProducts(category)
            .stateIn(viewModelScope, SharingStarted.Eagerly, emptyList())

    }
}