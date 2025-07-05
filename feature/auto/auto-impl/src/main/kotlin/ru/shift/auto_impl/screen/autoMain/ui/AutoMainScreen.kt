package ru.shift.auto_impl.screen.autoMain.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.shiftsummer2025.design_system.component.button.UiButton
import ru.shiftsummer2025.design_system.component.button.UiButtonStyle
import ru.shiftsummer2025.design_system.component.iconItem.calendarButtonActionItem
import ru.shiftsummer2025.design_system.component.input.UiSingleLineInput
import ru.shiftsummer2025.design_system.component.surface.ShiftSurface

@Composable
fun AutoMainScreen(
    modifier: Modifier = Modifier,
    onFiltersClick: () -> Unit,
) {
    ShiftSurface (
        modifier = modifier
            .fillMaxSize(),
    ) {
        LazyColumn {
            item {
                UiSingleLineInput(
                    text = "",
                    labelText = "Поиск",
                    placeholderText = "Поиск",
                ) {

                }
            }
            item {
                UiSingleLineInput(
                    text = "",
                    labelText = "Даты аренды",
                    placeholderText = "Даты аренды",
                    trailingIconItem = calendarButtonActionItem(onClick = {})
                ) {

                }
            }
            item {
                UiButton(
                    textInButton = "Фильтры",
                    style = UiButtonStyle.FILTER,
                    onClick = { onFiltersClick() }
                )
            }
        }
    }
}