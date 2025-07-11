package ru.shift.profile_impl.screen.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.shiftsummer2025.design_system.component.button.ShiftButton
import ru.shiftsummer2025.design_system.component.button.UiButtonStyle
import ru.shiftsummer2025.design_system.component.input.ShiftSingleLineInput
import ru.shiftsummer2025.design_system.component.surface.ShiftSurface

@Composable
fun ProfileMainScreen(
    modifier: Modifier = Modifier,
    firstName: String,
    lastName: String,
    middleName: String,
    phone: String,
    email: String,
    city: String,
    onFirstNameEdit: (String) -> Unit,
    onLastNameEdit: (String) -> Unit,
    onMiddleNameEdit: (String) -> Unit,
    onPhoneEdit: (String) -> Unit,
    onEmailEdit: (String) -> Unit,
    onCityEdit: (String) -> Unit,
    onUpdateUserInfoClick: () -> Unit,
    onLogoutClick: () -> Unit,
) {
    ShiftSurface(
        modifier = modifier
            .fillMaxSize(),
    ) {
        LazyColumn {
            item {
                ShiftSingleLineInput(
                    modifier = Modifier
                        .padding(
                            top = 16.dp,
                            bottom = 16.dp
                        ),
                    text = firstName,
                    labelText = "Имя*"
                ) {
                    onFirstNameEdit(it)
                }
            }
            item {
                ShiftSingleLineInput(
                    modifier = Modifier
                        .padding(bottom = 16.dp),
                    text = lastName,
                    labelText = "Фамилия*"
                ) {
                    onLastNameEdit(it)
                }
            }
            item {
                ShiftSingleLineInput(
                    modifier = Modifier
                        .padding(bottom = 16.dp),
                    text = middleName,
                    labelText = "Отчество*"
                ) {
                    onMiddleNameEdit(it)
                }
            }
            item {
                ShiftSingleLineInput(
                    modifier = Modifier
                        .padding(bottom = 16.dp),
                    text = phone,
                    labelText = "Номер телефона*"
                ) {
                    onPhoneEdit(it)
                }
            }
            item {
                ShiftSingleLineInput(
                    modifier = Modifier
                        .padding(bottom = 16.dp),
                    text = email,
                    labelText = "Email"
                ) {
                    onEmailEdit(it)
                }
            }
            item {
                ShiftSingleLineInput(
                    modifier = Modifier
                        .padding(bottom = 16.dp),
                    text = city,
                    labelText = "Город"
                ) {
                    onCityEdit(it)
                }
            }
            item {
                ShiftButton(
                    modifier = Modifier
                        .padding(
                            bottom = 8.dp,
                            top = 16.dp,
                        ),
                    textInButton = "Обновить данные",
                    style = UiButtonStyle.EMPTY,
                    onClick = { onUpdateUserInfoClick() }
                )
            }
            item {
                ShiftButton(
                    modifier = Modifier
                        .padding(bottom = 16.dp),
                    textInButton = "Выйти",
                    style = UiButtonStyle.PRIMARY,
                    onClick = { onLogoutClick() }
                )
            }
        }
    }
}