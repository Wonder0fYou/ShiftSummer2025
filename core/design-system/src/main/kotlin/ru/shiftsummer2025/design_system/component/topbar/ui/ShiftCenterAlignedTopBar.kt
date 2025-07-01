package ru.shiftsummer2025.design_system.component.topbar.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import ru.shiftsummer2025.design_system.component.topbar.model.TopBarConfiguration
import ru.shiftsummer2025.design_system.theme.ShiftTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShiftCenterAlignedTopBar(
    modifier: Modifier = Modifier,
    topBarConfiguration: TopBarConfiguration,
    colors: TopAppBarColors = TopAppBarColors(
        containerColor = ShiftTheme.colors.backgroundPrimary,
        scrolledContainerColor = Color.Unspecified,
        navigationIconContentColor = Color.Unspecified,
        titleContentColor = Color.Unspecified,
        actionIconContentColor = Color.Unspecified,
    )
) {
    CenterAlignedTopAppBar(
        modifier = modifier.fillMaxWidth(),
        title = topBarConfiguration.title,
        navigationIcon = {
            topBarConfiguration.navigationAction?.let { navigation ->
                TopBarIcon(
                    iconRes = navigation.iconRes,
                    contentDescription = navigation.contentDescription,
                    onClick = navigation.onClick,
                )
            }
        },
        actions = {
            topBarConfiguration.actions?.forEach { action ->
                TopBarIcon(
                    iconRes = action.iconRes,
                    contentDescription = action.contentDescription,
                    onClick = action.onClick
                )
            }
        },
        colors = colors
    )
}

@Composable
fun TopBarIcon(
    modifier: Modifier = Modifier,
    iconRes: Int,
    contentDescription: String?,
    onClick: () -> Unit,
) {
    IconButton(
        modifier = modifier,
        onClick = onClick
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = iconRes),
            contentDescription = contentDescription
        )
    }
}