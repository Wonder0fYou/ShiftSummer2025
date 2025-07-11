package ru.shift.auto_impl.screen.booking.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.shift.auto_impl.screen.booking.controller.state.BookingData
import ru.shiftsummer2025.design_system.component.button.ShiftButton
import ru.shiftsummer2025.design_system.component.button.UiButtonStyle
import ru.shiftsummer2025.design_system.component.iconItem.calendarButtonActionItem
import ru.shiftsummer2025.design_system.component.input.UiSingleLineInput
import ru.shiftsummer2025.design_system.component.surface.ShiftSurface

@Composable
fun StepOneScreen(
    modifier: Modifier = Modifier,
    bookingData: BookingData,
    onPickupLocationChanged: (String) -> Unit,
    onReturnLocationChanged: (String) -> Unit,
    onContinueClick: () -> Unit,
) {
    ShiftSurface(
        modifier = modifier
            .fillMaxSize(),
    ) {
        Column {
            UiSingleLineInput(
                modifier = Modifier.padding(vertical = 16.dp),
                text = "",
                labelText = "Даты аренды",
                placeholderText = "Даты аренды",
                trailingIconItem = calendarButtonActionItem(onClick = {})
            ) {

            }
            UiSingleLineInput(
                modifier = Modifier.padding(bottom = 16.dp),
                text = bookingData.pickupLocation ?: "",
                labelText = "Место получения",
                placeholderText = "Место получения",
                onTextChange = onPickupLocationChanged
            )
            UiSingleLineInput(
                modifier = Modifier.padding(bottom = 16.dp),
                text = bookingData.returnLocation ?: "",
                labelText = "Место возврата",
                placeholderText = "Место возврата",
                onTextChange = onReturnLocationChanged
            )
            Spacer(modifier = Modifier.weight(1f))
            ShiftButton(
                modifier = Modifier.padding(bottom = 16.dp),
                textInButton = "Продолжить",
                style = UiButtonStyle.PRIMARY,
                onClick = { onContinueClick() }
            )
        }
    }
}