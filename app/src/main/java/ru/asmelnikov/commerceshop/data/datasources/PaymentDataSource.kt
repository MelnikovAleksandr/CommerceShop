package ru.asmelnikov.commerceshop.data.datasources

import ru.asmelnikov.commerceshop.domain.models.order.Order
import ru.asmelnikov.commerceshop.domain.models.order.PaymentResult

interface PaymentDataSource {
    suspend fun doPayment(order: Order): PaymentResult
}