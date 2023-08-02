package ru.asmelnikov.commerceshop.ui.features.payment.state

import ru.asmelnikov.commerceshop.domain.models.order.Payment
import ru.asmelnikov.commerceshop.domain.models.order.PaymentResult

data class PaymentState(
    val paymentInformation: Payment = Payment(),
    val isLoading: Boolean = false,
    val paymentResult: PaymentResult? = null,
    val errorMessage: String? = null
)
