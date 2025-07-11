package ru.shift.auto_impl.screen.booking.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.shiftsummer2025.design_system.component.button.ShiftButton
import ru.shiftsummer2025.design_system.component.button.UiButtonStyle
import ru.shiftsummer2025.design_system.component.surface.ShiftSurface

@Composable
fun StepThreeScreen(
    modifier: Modifier = Modifier,
    onOrderClick: () -> Unit,
) {
    ShiftSurface(
        modifier = modifier
            .fillMaxSize(),
    ) {
        LazyColumn {
            item {
                ShiftButton(
                    modifier = Modifier.padding(bottom = 16.dp),
                    textInButton = "Оформить",
                    style = UiButtonStyle.PRIMARY,
                    onClick = { onOrderClick() }
                )
            }
        }
    }
}