package ru.shiftsummer2025.design_system.component.topbar.model

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import ru.shiftsummer2025.design_system.component.iconItem.ActionIconItem

@Stable
data class TopBarConfiguration(
    val title: @Composable () -> Unit = {},
    val navigationAction: ActionIconItem? = null,
    val actions: List<ActionIconItem>? = null,
    val titleTextColor: Color? = null,
    val backgroundColor: Color? = null,
)
