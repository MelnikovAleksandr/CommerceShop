package ru.asmelnikov.commerceshop.data.repository

import ru.asmelnikov.commerceshop.data.datasources.PaymentDataSource
import ru.asmelnikov.commerceshop.domain.models.order.Order
import ru.asmelnikov.commerceshop.domain.models.order.PaymentResult
import ru.asmelnikov.commerceshop.domain.repository.PaymentRepository

class PaymentRepositoryImpl(
    private val paymentDataSource: PaymentDataSource,
) : PaymentRepository {
    override suspend fun orderPayment(order: Order): PaymentResult {
        return paymentDataSource.doPayment(order)
    }
}