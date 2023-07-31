package ru.asmelnikov.commerceshop.domain.models.order

data class PaymentResult(
    val status: Boolean,
    val payment: Payment
)