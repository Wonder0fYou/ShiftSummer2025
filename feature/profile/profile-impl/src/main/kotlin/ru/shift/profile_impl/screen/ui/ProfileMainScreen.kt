package ru.shift.profile_impl.screen.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.shiftsummer2025.design_system.component.button.UiButton
import ru.shiftsummer2025.design_system.component.button.UiButtonStyle
import ru.shiftsummer2025.design_system.component.input.UiSingleLineInput
import ru.shiftsummer2025.design_system.component.surface.ShiftSurface

@Composable
fun ProfileMainScreen(
    modifier: Modifier = Modifier,
) {
    ShiftSurface(
        modifier = modifier
            .fillMaxSize(),
    ) {
        LazyColumn {
            item {
                UiSingleLineInput(
                    text = "",
                    labelText = "Имя*"
                ) {

                }
            }
            item {
                UiSingleLineInput(
                    text = "",
                    labelText = "Фамилия*"
                ) {

                }
            }
            item {
                UiSingleLineInput(
                    text = "",
                    labelText = "Отчество*"
                ) {

                }
            }
            item {
                UiSingleLineInput(
                    text = "",
                    labelText = "Номер телефона*"
                ) {

                }
            }
            item {
                UiSingleLineInput(
                    text = "",
                    labelText = "Email"
                ) {

                }
            }
            item {
                UiSingleLineInput(
                    text = "",
                    labelText = "Город"
                ) {

                }
            }
            item {
                UiButton(
                    textInButton = "Обновить данные",
                    style = UiButtonStyle.EMPTY,
                    onClick = { }
                )
            }
            item {
                UiButton(
                    textInButton = "Выйти",
                    style = UiButtonStyle.PRIMARY,
                    onClick = { }
                )
            }
        }
    }
}