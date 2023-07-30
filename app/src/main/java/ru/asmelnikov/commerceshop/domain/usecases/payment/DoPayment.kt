package ru.asmelnikov.commerceshop.domain.usecases.payment

import ru.asmelnikov.commerceshop.domain.models.order.Order
import ru.asmelnikov.commerceshop.domain.models.order.PaymentResult
import ru.asmelnikov.commerceshop.domain.repository.PaymentRepository

class DoPayment(
    private val repository: PaymentRepository,
) {

    suspend fun doPayment(order: Order): PaymentResult {
        return repository.orderPayment(order)
    }
}