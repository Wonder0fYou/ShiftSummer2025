package ru.shiftsummer2025.design_system.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ru.shiftsummer2025.design_system.component.text.ShiftText
import ru.shiftsummer2025.design_system.component.text.TextStyle

@Composable
fun ErrorState(
    reason: String
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        ShiftText(
            text = reason,
            textStyle = TextStyle.TITLE_H2,
        )
    }
}