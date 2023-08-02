package ru.asmelnikov.commerceshop.ui.features.checkout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ru.asmelnikov.commerceshop.R
import ru.asmelnikov.commerceshop.domain.models.order.Order
import ru.asmelnikov.commerceshop.domain.models.order.SummaryTotals
import ru.asmelnikov.commerceshop.ui.composables.buttons.StandardButton
import ru.asmelnikov.commerceshop.ui.composables.cards.SummaryCard
import ru.asmelnikov.commerceshop.ui.features.checkout.components.CheckoutSection
import ru.asmelnikov.commerceshop.ui.features.checkout.components.ContactInformation
import ru.asmelnikov.commerceshop.ui.features.checkout.components.PaymentInformation
import ru.asmelnikov.commerceshop.ui.features.checkout.events.ContactFormEvent
import ru.asmelnikov.commerceshop.ui.features.checkout.events.PaymentFormEvent
import ru.asmelnikov.commerceshop.ui.features.checkout.state.ContactFormState
import ru.asmelnikov.commerceshop.ui.features.checkout.state.PaymentFormState
import ru.asmelnikov.commerceshop.ui.features.checkout.state.successValidated
import ru.asmelnikov.commerceshop.ui.theme.LightGrayBackground
import ru.asmelnikov.commerceshop.ui.utils.StateVsEvent


@Composable
fun CheckoutScreen(
    summary: SummaryTotals,
    goToPlaceOrder: (Order) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: CheckoutViewModel = hiltViewModel()
) {
    CheckoutUI(
        summary = summary,
        contactUiState = viewModel.contactUiState,
        onContactEvent = viewModel.onContactFormEvent,
        paymentUiState = viewModel.paymentUiState,
        onPaymentEvent = viewModel.onPaymentFormEvent,
        onContinueOrder = { goToPlaceOrder(viewModel.getOrder(summary)) },
        modifier = modifier
    )
}

@Composable
fun CheckoutUI(
    summary: SummaryTotals,
    contactUiState: ContactFormState,
    onContactEvent: (ContactFormEvent) -> Unit,
    paymentUiState: PaymentFormState,
    onPaymentEvent: (PaymentFormEvent) -> Unit,
    onContinueOrder: () -> Unit,
    modifier: Modifier = Modifier,
) {
    CheckoutElements(
        summary = summary,
        contact = contactUiState,
        onContactEvent = onContactEvent,
        payment = paymentUiState,
        onPaymentEvent = onPaymentEvent,
        onContinueOrder = onContinueOrder,
        modifier = modifier.background(LightGrayBackground)
    )
}

@Composable
fun CheckoutElements(
    summary: SummaryTotals,
    contact: ContactFormState,
    onContactEvent: (ContactFormEvent) -> Unit,
    payment: PaymentFormState,
    onPaymentEvent: (PaymentFormEvent) -> Unit,
    onContinueOrder: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier
            .verticalScroll(rememberScrollState())
            .padding(vertical = 16.dp, horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        SummaryCard(
            numberItems = summary.numberItems,
            totalItems = summary.totalItems,
            shippingCost = summary.shippingCost,
            taxCost = summary.taxCost,
            total = summary.total,
            modifier = modifier
        )
        CheckoutSection(
            title = "Contact Information"
        ) {
            ContactInformation(
                nameStateVsEvent = StateVsEvent(
                    value = contact.username,
                    onValueChange = {
                        onContactEvent(ContactFormEvent.OnNameChange(it))
                    }),
                phoneStateVsEvent = StateVsEvent(
                    value = contact.phone,
                    onValueChange = {
                        onContactEvent(ContactFormEvent.OnPhoneChange(it))
                    }),
                addressStateVsEvent = StateVsEvent(
                    value = contact.address,
                    onValueChange = {
                        onContactEvent(ContactFormEvent.OnAddressChange(it))
                    }),
                modifier = modifier
            )
        }
        CheckoutSection(
            title = "Payment Information"
        ) {
            PaymentInformation(
                nameStateVsEvent = StateVsEvent(
                    value = payment.name,
                    onValueChange = {
                        onPaymentEvent(PaymentFormEvent.OnNameChange(it))
                    }),
                numberStateVsEvent = StateVsEvent(
                    value = payment.number,
                    onValueChange = {
                        onPaymentEvent(PaymentFormEvent.OnNumberChange(it))
                    }),
                monthStateVsEvent = StateVsEvent(
                    value = payment.month,
                    onValueChange = {
                        onPaymentEvent(PaymentFormEvent.OnMonthChange(it))
                    }),
                yearStateVsEvent = StateVsEvent(
                    value = payment.year,
                    onValueChange = {
                        onPaymentEvent(PaymentFormEvent.OnYearChange(it))
                    }),
                codeStateVsEvent = StateVsEvent(
                    value = payment.code,
                    onValueChange = {
                        onPaymentEvent(PaymentFormEvent.OnCodeChange(it))
                    }),
            )
        }
        StandardButton(
            text = stringResource(R.string.continue_order),
            onClicked = onContinueOrder,
            enabled = contact.successValidated && payment.successValidated
        )
    }
}