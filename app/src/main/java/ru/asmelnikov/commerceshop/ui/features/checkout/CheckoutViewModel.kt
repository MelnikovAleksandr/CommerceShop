package ru.asmelnikov.commerceshop.ui.features.checkout

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.asmelnikov.commerceshop.domain.models.order.CardInformation
import ru.asmelnikov.commerceshop.domain.models.order.Order
import ru.asmelnikov.commerceshop.domain.models.order.SummaryTotals
import ru.asmelnikov.commerceshop.ui.features.checkout.events.ContactFormEvent
import ru.asmelnikov.commerceshop.ui.features.checkout.events.PaymentFormEvent
import ru.asmelnikov.commerceshop.ui.features.checkout.state.ContactFormState
import ru.asmelnikov.commerceshop.ui.features.checkout.state.PaymentFormState
import javax.inject.Inject

@HiltViewModel
class CheckoutViewModel @Inject constructor() : ViewModel() {

    var contactUiState by mutableStateOf(ContactFormState())
        private set

    var paymentUiState by mutableStateOf(PaymentFormState())
        private set

    val onContactFormEvent: (ContactFormEvent) -> Unit = { event ->
        contactUiState = when (event) {
            is ContactFormEvent.OnNameChange -> {
                contactUiState.copy(username = event.name)
            }
            is ContactFormEvent.OnPhoneChange -> {
                contactUiState.copy(phone = event.phone)
            }
            is ContactFormEvent.OnAddressChange -> {
                contactUiState.copy(address = event.address)
            }
        }
    }

    val onPaymentFormEvent: (PaymentFormEvent) -> Unit = { event ->
        paymentUiState = when (event) {
            is PaymentFormEvent.OnNameChange -> {
                paymentUiState.copy(name = event.name)
            }
            is PaymentFormEvent.OnNumberChange -> {
                paymentUiState.copy(number = event.number)
            }
            is PaymentFormEvent.OnMonthChange -> {
                paymentUiState.copy(month = event.month)
            }
            is PaymentFormEvent.OnYearChange -> {
                paymentUiState.copy(year = event.year)
            }
            is PaymentFormEvent.OnCodeChange -> {
                paymentUiState.copy(code = event.code)
            }
        }
    }

    fun getOrder(summaryTotals: SummaryTotals): Order {
        return orderStateToModel(
            contactUiState,
            paymentUiState,
            summaryTotals)
    }

    private fun orderStateToModel(
        contact: ContactFormState,
        payment: PaymentFormState,
        summary: SummaryTotals,
    ): Order {
        return Order(
            name = contact.username,
            phone = contact.phone,
            address = contact.address,
            cardInformation = CardInformation(
                name = payment.name,
                number = payment.number,
                month = payment.month,
                year = payment.year,
                code = payment.code),
            summary = summary)
    }
}