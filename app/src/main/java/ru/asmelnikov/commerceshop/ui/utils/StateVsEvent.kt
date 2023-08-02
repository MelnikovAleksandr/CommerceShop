package ru.asmelnikov.commerceshop.ui.utils

data class StateVsEvent(
    val value: String = "",
    val onValueChange: (String) -> Unit = {}
)
