package ru.shift.auto_impl.screen.booking.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.shift.auto_impl.screen.booking.controller.state.BookingData
import ru.shiftsummer2025.design_system.component.button.UiButton
import ru.shiftsummer2025.design_system.component.button.UiButtonStyle
import ru.shiftsummer2025.design_system.component.input.UiSingleLineInput
import ru.shiftsummer2025.design_system.component.surface.ShiftSurface

@Composable
fun StepTwoScreen(
    modifier: Modifier = Modifier,
    bookingData: BookingData,
    onFirstNameChanged: (String) -> Unit,
    onLastNameChanged: (String) -> Unit,
    onMiddleNameChanged: (String) -> Unit,
    onBirthDateChanged: (String) -> Unit,
    onPhoneChanged: (String) -> Unit,
    onEmailChanged: (String) -> Unit,
    onCommentChanged: (String) -> Unit,
    onContinueClick: () -> Unit,
) {
    ShiftSurface(
        modifier = modifier
            .fillMaxSize(),
    ) {
        LazyColumn {
            item {
                UiSingleLineInput(
                    modifier = Modifier.padding(vertical = 16.dp),
                    text = bookingData.lastName ?: "",
                    labelText = "Фамилия",
                    placeholderText = "Фамилия",
                    onTextChange = onLastNameChanged
                )
            }
            item {
                UiSingleLineInput(
                    modifier = Modifier.padding(bottom = 16.dp),
                    text = bookingData.firstName ?: "",
                    labelText = "Имя",
                    placeholderText = "Имя",
                    onTextChange = onFirstNameChanged
                )
            }
            item {
                UiSingleLineInput(
                    modifier = Modifier.padding(bottom = 16.dp),
                    text = bookingData.middleName ?: "",
                    labelText = "Отчество",
                    placeholderText = "Отчество",
                    onTextChange = onMiddleNameChanged
                )
            }
            item {
                UiSingleLineInput(
                    modifier = Modifier.padding(bottom = 16.dp),
                    text = bookingData.birthDate ?: "",
                    labelText = "Дата рождения",
                    placeholderText = "Дата рождения",
                    onTextChange = onBirthDateChanged
                )
            }
            item {
                UiSingleLineInput(
                    modifier = Modifier.padding(bottom = 16.dp),
                    text = bookingData.phone ?: "",
                    labelText = "Номер телефона",
                    placeholderText = "Номер телефона",
                    onTextChange = onPhoneChanged
                )
            }
            item {
                UiSingleLineInput(
                    modifier = Modifier.padding(bottom = 16.dp),
                    text = bookingData.email ?: "",
                    labelText = "Электронная почта",
                    placeholderText = "Электронная почта",
                    onTextChange = onEmailChanged
                )
            }
            item {
                UiSingleLineInput(
                    modifier = Modifier.padding(bottom = 16.dp),
                    text = bookingData.comment ?: "",
                    labelText = "Комментарий",
                    placeholderText = "Введите дополнительную информацию",
                    onTextChange = onCommentChanged
                )
            }
            item {
                UiButton(
                    modifier = Modifier.padding(bottom = 16.dp),
                    textInButton = "Продолжить",
                    style = UiButtonStyle.PRIMARY,
                    onClick = { onContinueClick() }
                )
            }
        }
    }
}