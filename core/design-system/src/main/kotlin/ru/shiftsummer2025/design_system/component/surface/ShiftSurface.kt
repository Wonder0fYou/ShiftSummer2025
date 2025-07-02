package ru.shiftsummer2025.design_system.component.surface

import androidx.compose.foundation.BorderStroke
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import ru.shiftsummer2025.design_system.theme.ShiftTheme

@Composable
fun ShiftSurface(
    modifier: Modifier = Modifier,
    color: Color = ShiftTheme.colors.backgroundPrimary,
    contentColor: Color = ShiftTheme.colors.backgroundPrimary,
    shape: Shape = RectangleShape,
    border: BorderStroke? = null,
    content: @Composable () -> Unit
) {
    Surface(
        modifier = modifier,
        color = color,
        contentColor = contentColor,
        content = content,
        shape = shape,
        border = border
    )
}