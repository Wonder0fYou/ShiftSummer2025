package ru.shift.auto_impl.screen.booking.topbar

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.shiftsummer2025.design_system.component.iconItem.shevronButtonActionItem
import ru.shiftsummer2025.design_system.component.topbar.model.TopBarConfiguration
import ru.shiftsummer2025.design_system.component.topbar.ui.ShiftCenterAlignedTopBar
import ru.shiftsummer2025.design_system.component.topbar.ui.TopBarTitleWithText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StepThreeScreenTopBar(
    modifier: Modifier = Modifier,
    onNavigationClick: () -> Unit,
) {
    val topBarConfiguration = TopBarConfiguration(
        title = {
            TopBarTitleWithText(text = "Проверка данных")
        },
        navigationAction = shevronButtonActionItem(onNavigationClick)
    )
    ShiftCenterAlignedTopBar(
        modifier = modifier,
        topBarConfiguration = topBarConfiguration
    )
}