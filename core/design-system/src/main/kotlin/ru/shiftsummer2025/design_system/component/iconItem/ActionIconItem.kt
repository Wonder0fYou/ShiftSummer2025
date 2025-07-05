package ru.shiftsummer2025.design_system.component.iconItem

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Stable
import ru.shiftsummer2025.design_system.R

@Stable
data class ActionIconItem(
    @DrawableRes
    val iconRes : Int,
    val contentDescription: String? = null,
    val onClick: () -> Unit,
)

fun crossButtonActionItem(onClick: () -> Unit) = ActionIconItem(
    iconRes = R.drawable.ic_cross,
    onClick = onClick,
    contentDescription = "Cross",
)

fun calendarButtonActionItem(onClick: () -> Unit) = ActionIconItem(
    iconRes = R.drawable.ic_calendar,
    onClick = onClick,
    contentDescription = "Calendar"
)
