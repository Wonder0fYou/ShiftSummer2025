package ru.shiftsummer2025.design_system.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.shiftsummer2025.design_system.component.circularProgressIndicator.ShiftCircularProgressIndicator

@Composable
fun LoadingState() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        ShiftCircularProgressIndicator(
            modifier = Modifier.size(48.dp)
        )
    }
}