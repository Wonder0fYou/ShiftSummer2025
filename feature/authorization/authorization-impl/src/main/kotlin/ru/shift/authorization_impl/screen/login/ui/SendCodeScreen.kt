package ru.shift.authorization_impl.screen.login.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.shiftsummer2025.design_system.component.button.ShiftButton
import ru.shiftsummer2025.design_system.component.button.UiButtonStyle
import ru.shiftsummer2025.design_system.component.input.ShiftSingleLineInput
import ru.shiftsummer2025.design_system.component.surface.ShiftSurface
import ru.shiftsummer2025.design_system.component.text.ShiftText
import ru.shiftsummer2025.design_system.component.text.TextStyle

@Composable
fun SendCodeScreen(
    modifier: Modifier = Modifier,
    phone: String,
    onEditPhoneInput: (String) -> Unit,
    onSendCodeClick: () -> Unit,
    isSendCodeButtonEnabled: Boolean,
) {
    ShiftSurface (
        modifier = modifier
            .fillMaxSize(),
    ) {
        Column (
            modifier = Modifier
                .fillMaxWidth(),
        ){
            ShiftText(
                modifier = Modifier
                    .padding(16.dp),
                text = "Введите номер телефона для входа в личный кабинет",
                textStyle = TextStyle.BODY_REGULAR_16
            )
            ShiftSingleLineInput(
                modifier = Modifier
                    .padding(bottom = 16.dp),
                text = phone,
                placeholderText = "Телефон"
            ) {
                onEditPhoneInput(it)
            }
            ShiftButton(
                modifier = Modifier
                    .padding(bottom = 16.dp),
                textInButton = "Продолжить",
                style = UiButtonStyle.PRIMARY,
                isEnabled = isSendCodeButtonEnabled,
                onClick = { onSendCodeClick() }
            )
        }
    }
}