package ru.shiftsummer2025.design_system.component.bottomSheet

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import ru.shiftsummer2025.design_system.theme.ShiftTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShiftBottomSheet(
    onDismissRequest: () -> Unit,
    sheetState: SheetState = rememberModalBottomSheetState(),
    content: @Composable (ColumnScope) -> Unit
) {
    ModalBottomSheet(
        onDismissRequest = {
            onDismissRequest()
        },
        containerColor = ShiftTheme.colors.backgroundPrimary,
        sheetState = sheetState,
        content = content
    )
}