package ru.shiftsummer2025.design_system.component.circularProgressIndicator

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import ru.shiftsummer2025.design_system.theme.ShiftTheme

@Composable
fun ShiftCircularProgressIndicator(
    modifier: Modifier = Modifier,
    color: Color = ShiftTheme.colors.brandLeasingPrimary
) {
    CircularProgressIndicator(
        modifier = modifier,
        color = color
    )
}