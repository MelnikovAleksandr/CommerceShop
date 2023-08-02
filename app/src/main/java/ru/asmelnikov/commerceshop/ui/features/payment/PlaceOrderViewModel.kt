package ru.asmelnikov.commerceshop.ui.features.payment

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.asmelnikov.commerceshop.common.preview.PreviewData
import ru.asmelnikov.commerceshop.domain.usecases.payment.PaymentUseCases
import ru.asmelnikov.commerceshop.ui.features.payment.state.PaymentState
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class PlaceOrderViewModel @Inject constructor(
    private val paymentUseCases: PaymentUseCases,
) : ViewModel() {

    var paymentUiState by mutableStateOf(PaymentState())
        private set

    fun makePayment() {
        viewModelScope.launch {
            paymentUiState = paymentUiState.copy(isLoading = true)
            try {
                val paymentResult = paymentUseCases.doPayment
                    .doPayment(order = PreviewData.order)
                paymentUiState =
                    paymentUiState.copy(
                        isLoading = false,
                        paymentResult = paymentResult
                    )
                println(paymentResult)
            } catch (ioe: IOException) {
                paymentUiState = paymentUiState.copy(
                    isLoading = false,
                    errorMessage = "Error with the transaction"
                )
            }
        }
    }
}