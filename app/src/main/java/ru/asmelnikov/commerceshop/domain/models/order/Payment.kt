package ru.asmelnikov.commerceshop.domain.models.order

data class Payment(
    val status: String = "",
    val reference: String = ""
)