package ru.asmelnikov.commerceshop.domain.models.order

data class CardInformation(
    val name: String,
    val number: String,
    val month: String,
    val year: String,
    val code: String,
)