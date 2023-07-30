package ru.asmelnikov.commerceshop.domain.repository

import ru.asmelnikov.commerceshop.domain.models.order.Order
import ru.asmelnikov.commerceshop.domain.models.order.PaymentResult

interface PaymentRepository {
    suspend fun orderPayment(order: Order): PaymentResult
}