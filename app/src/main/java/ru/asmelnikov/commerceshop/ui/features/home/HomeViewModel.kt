package ru.asmelnikov.commerceshop.ui.features.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import ru.asmelnikov.commerceshop.domain.usecases.product.ProductUseCases
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val productUseCases: ProductUseCases
) : ViewModel() {
    val productListState = productUseCases.getProducts.getProducts()
        .stateIn(viewModelScope, SharingStarted.Eagerly, emptyList())

    val categoryListState = productUseCases.getCategories.getCategories()
        .stateIn(viewModelScope, SharingStarted.Eagerly, emptyList())
}