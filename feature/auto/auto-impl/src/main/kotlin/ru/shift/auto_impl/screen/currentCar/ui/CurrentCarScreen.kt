package ru.shift.auto_impl.screen.currentCar.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import ru.shift.auto_domain.CarWithRents
import ru.shiftsummer2025.design_system.component.button.ShiftButton
import ru.shiftsummer2025.design_system.component.button.UiButtonStyle
import ru.shiftsummer2025.design_system.component.divider.ShiftDivider
import ru.shiftsummer2025.design_system.component.text.ShiftText
import ru.shiftsummer2025.design_system.component.text.TextStyle

@Composable
fun CurrentCarScreen(
    modifier: Modifier = Modifier,
    car: CarWithRents,
    onBackClick: () -> Unit,
    onOrderClick: (String) -> Unit,
) {
    LazyColumn(
        modifier = modifier
    ) {
        item {
            val mediaCar = car.media.find { it.isCover }?.url ?: ""
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                model = mediaCar,
                alignment = Alignment.Center,
                contentDescription = "Фото машины"
            )
        }
        item {
            ShiftText(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        bottom = 16.dp,
                        start = 16.dp,
                        end = 16.dp,
                    ),
                text = car.name,
                textStyle = TextStyle.TITLE_H2,
                textAlign = TextAlign.Center
            )
        }
        item {
            ShiftText(
                modifier = Modifier
                    .padding(
                        bottom = 16.dp,
                        start = 16.dp,
                        end = 16.dp,
                    ),
                text = "Характеристики",
                textStyle = TextStyle.PARAGRAPH_16
            )
        }
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    ShiftText(
                        modifier = Modifier
                            .padding(
                                bottom = 16.dp,
                                start = 16.dp,
                            ),
                        text = "Коробка передач",
                        textStyle = TextStyle.PARAGRAPH_16
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    ShiftText(
                        modifier = Modifier
                            .padding(
                                bottom = 16.dp,
                                end = 16.dp,
                            ),
                        text = car.transmission,
                        textStyle = TextStyle.PARAGRAPH_16
                    )
                }
                ShiftDivider()
            }
        }
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    ShiftText(
                        modifier = Modifier
                            .padding(
                                top = 16.dp,
                                bottom = 16.dp,
                                start = 16.dp,
                            ),
                        text = "Сторона руля",
                        textStyle = TextStyle.PARAGRAPH_16
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    ShiftText(
                        modifier = Modifier
                            .padding(
                                top = 16.dp,
                                bottom = 16.dp,
                                end = 16.dp,
                            ),
                        text = car.steering,
                        textStyle = TextStyle.PARAGRAPH_16
                    )
                }
                ShiftDivider()
            }
        }
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    ShiftText(
                        modifier = Modifier
                            .padding(
                                top = 16.dp,
                                bottom = 16.dp,
                                start = 16.dp,
                            ),
                        text = "Тип кузова",
                        textStyle = TextStyle.PARAGRAPH_16
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    ShiftText(
                        modifier = Modifier
                            .padding(
                                top = 16.dp,
                                bottom = 16.dp,
                                end = 16.dp,
                            ),
                        text = car.bodyType,
                        textStyle = TextStyle.PARAGRAPH_16
                    )
                }
                ShiftDivider()
            }
        }
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    ShiftText(
                        modifier = Modifier
                            .padding(
                                top = 16.dp,
                                bottom = 16.dp,
                                start = 16.dp,
                            ),
                        text = "Цвет",
                        textStyle = TextStyle.PARAGRAPH_16
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    ShiftText(
                        modifier = Modifier
                            .padding(
                                top = 16.dp,
                                bottom = 16.dp,
                                end = 16.dp,
                            ),
                        text = car.color,
                        textStyle = TextStyle.PARAGRAPH_16
                    )
                }
                ShiftDivider()
            }
        }
        item {
            ShiftText(
                modifier = Modifier
                    .padding(
                        top = 16.dp,
                        bottom = 16.dp,
                        start = 16.dp,
                        end = 16.dp,
                    ),
                text = "Стоимость",
                textStyle = TextStyle.PARAGRAPH_16
            )
            ShiftDivider()
        }
        item {
            ShiftText(
                modifier = Modifier
                    .padding(
                        top = 16.dp,
                        bottom = 16.dp,
                        start = 16.dp,
                        end = 16.dp,
                    ),
                text = "Итого: " + car.price + "₽",
                textStyle = TextStyle.PARAGRAPH_16
            )
        }
        item {
            ShiftButton(
                modifier = Modifier
                    .padding(bottom = 8.dp),
                textInButton = "Назад",
                style = UiButtonStyle.EMPTY,
                onClick = { onBackClick() }
            )
        }
        item {
            ShiftButton(
                modifier = Modifier
                    .padding(bottom = 16.dp),
                textInButton = "Забронировать",
                style = UiButtonStyle.PRIMARY,
                onClick = { onOrderClick(car.id) }
            )
        }
    }
}