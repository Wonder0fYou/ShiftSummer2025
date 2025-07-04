package ru.shiftsummer2025.design_system.bottombar

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ru.shiftsummer2025.design_system.theme.ShiftTheme

@Composable
fun ShiftNavigationBar(
    modifier: Modifier = Modifier,
    containerColor: Color = ShiftTheme.colors.backgroundPrimary,
    tonalElevation: Dp = 40.dp,
    content: @Composable() (RowScope.() -> Unit)
) {
    NavigationBar(
        modifier = modifier,
        containerColor = containerColor,
        tonalElevation = tonalElevation,
        content = content
    )
}