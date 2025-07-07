package ru.shiftsummer2025.design_system.component.divider

import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ru.shiftsummer2025.design_system.theme.ShiftTheme

@Composable
fun ShiftDivider(
    modifier: Modifier = Modifier,
    thickness: Dp = 1.dp,
    color: Color = ShiftTheme.colors.borderMedium
) {
    HorizontalDivider(
        modifier = modifier,
        thickness = thickness,
        color = color
    )
}