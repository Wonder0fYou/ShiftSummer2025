package ru.shift.auto_impl.screen.autoMain.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.shift.auto_domain.Cars
import ru.shiftsummer2025.design_system.component.button.ShiftButton
import ru.shiftsummer2025.design_system.component.button.UiButtonStyle
import ru.shiftsummer2025.design_system.component.card.ShiftCarMainCard
import ru.shiftsummer2025.design_system.component.iconItem.calendarButtonActionItem
import ru.shiftsummer2025.design_system.component.input.UiSingleLineInput
import ru.shiftsummer2025.design_system.component.surface.ShiftSurface

@Composable
fun AutoMainScreen(
    modifier: Modifier = Modifier,
    cars: List<Cars>,
    onFiltersClick: () -> Unit,
    onCarClick: (Cars) -> Unit,
) {
    ShiftSurface(
        modifier = modifier
            .fillMaxSize(),
    ) {
        LazyColumn {
            item {
                UiSingleLineInput(
                    modifier = Modifier
                        .padding(
                            top = 16.dp,
                            bottom = 16.dp
                        ),
                    text = "",
                    labelText = "Поиск",
                    placeholderText = "Поиск",
                ) {

                }
            }
            item {
                UiSingleLineInput(
                    modifier = Modifier
                        .padding(bottom = 16.dp),
                    text = "",
                    labelText = "Даты аренды",
                    placeholderText = "Даты аренды",
                    trailingIconItem = calendarButtonActionItem(onClick = {})
                ) {

                }
            }
            item {
                ShiftButton(
                    modifier = Modifier
                        .padding(bottom = 16.dp),
                    textInButton = "Фильтры",
                    style = UiButtonStyle.FILTER,
                    onClick = { onFiltersClick() }
                )
            }
            items(cars) { car ->
                val mediaCars = car.media.find { it.isCover }?.url ?: ""
                ShiftCarMainCard(
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                        .clickable {
                            onCarClick(car)
                        },
                    urlImage = mediaCars,
                    autoName = car.name,
                    transmission = car.transmission,
                    price = car.price
                )
            }
        }
    }
}