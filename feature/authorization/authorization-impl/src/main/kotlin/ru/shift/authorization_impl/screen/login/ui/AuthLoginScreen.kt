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
import ru.shiftsummer2025.design_system.component.input.UiSingleLineInput
import ru.shiftsummer2025.design_system.component.surface.ShiftSurface
import ru.shiftsummer2025.design_system.component.text.ShiftText
import ru.shiftsummer2025.design_system.component.text.TextStyle

@Composable
fun AuthLoginScreen(
    modifier: Modifier = Modifier,
    phone: String,
    code: String,
    onEditPhoneInput: (String) -> Unit,
    onEditCodeInput: (String) -> Unit,
    onLoginClick: () -> Unit,
    isLoginButtonEnable: Boolean
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
                text = "Введите проверочный код для входа в личный кабинет",
                textStyle = TextStyle.BODY_REGULAR_16
            )
            UiSingleLineInput(
                modifier = Modifier
                    .padding(bottom = 16.dp),
                text = phone,
                placeholderText = "Телефон"
            ) {
                onEditPhoneInput(it)
            }
            UiSingleLineInput(
                modifier = Modifier
                    .padding(bottom = 16.dp),
                text = code,
                placeholderText = "Проверочный код"
            ) {
                onEditCodeInput(it)
            }
            ShiftButton(
                modifier = Modifier
                    .padding(bottom = 16.dp),
                textInButton = "Войти",
                style = UiButtonStyle.PRIMARY,
                isEnabled = isLoginButtonEnable,
                onClick = { onLoginClick() }
            )
        }
    }
}