package ru.shiftsummer2025.design_system.bottombar

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import ru.shiftsummer2025.design_system.theme.ShiftTheme

@Composable
fun RowScope.BottomBarNavigationItem(
    isSelected: Boolean,
    label: String,
    iconRes: Int,
    onClick: () -> Unit,
) {
    NavigationBarItem(
        selected = isSelected,
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = ShiftTheme.colors.brandLeasingPrimary,
            indicatorColor = Color.Transparent,
            selectedTextColor = ShiftTheme.colors.brandLeasingPrimary,
        ),
        label = {
            Text(text = label)
        },
        icon = {
            Icon(
                imageVector = ImageVector.vectorResource(id = iconRes),
                contentDescription = null
            )
        },
        onClick = onClick
    )
}