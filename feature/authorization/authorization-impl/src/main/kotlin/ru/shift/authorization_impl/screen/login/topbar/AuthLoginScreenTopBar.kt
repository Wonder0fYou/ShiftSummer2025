package ru.shift.authorization_impl.screen.login.topbar

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.shiftsummer2025.design_system.component.iconItem.crossButtonActionItem
import ru.shiftsummer2025.design_system.component.topbar.model.TopBarConfiguration
import ru.shiftsummer2025.design_system.component.topbar.ui.ShiftCenterAlignedTopBar
import ru.shiftsummer2025.design_system.component.topbar.ui.TopBarTitleWithText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthLoginScreenTopBar(
    modifier: Modifier = Modifier,
    onNavigationClick: () -> Unit,
) {
    val topBarConfiguration = TopBarConfiguration(
        title = {
            TopBarTitleWithText(text = "Авторизация")
        },
        navigationAction = crossButtonActionItem(onNavigationClick)
    )
    ShiftCenterAlignedTopBar(
        modifier = modifier,
        topBarConfiguration = topBarConfiguration
    )
}