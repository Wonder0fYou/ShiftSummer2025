package ru.shiftsummer2025.design_system.component.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.shiftsummer2025.design_system.R
import ru.shiftsummer2025.design_system.component.text.ShiftText
import ru.shiftsummer2025.design_system.component.text.TextStyle
import ru.shiftsummer2025.design_system.theme.ShiftTheme

enum class UiButtonStyle {
    PRIMARY,
    FILTER,
    EMPTY,
}

@Composable
fun ShiftButton(
    modifier: Modifier = Modifier,
    textInButton: String,
    style: UiButtonStyle,
    shape: RoundedCornerShape = RoundedCornerShape(10.dp),
    isEnabled: Boolean = true,
    onClick: () -> Unit,
    underButtonContent: @Composable (() -> Unit)? = null
) {
    Column(
        modifier = modifier
            .wrapContentSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        when (style) {
            UiButtonStyle.PRIMARY -> Button(
                modifier = modifier
                    .fillMaxWidth()
                    .heightIn(min = 56.dp),
                shape = shape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = ShiftTheme.colors.brandLeasingPrimary,
                    contentColor = ShiftTheme.colors.textInvert,
                    disabledContainerColor = ShiftTheme.colors.brandLeasingPrimary,
                    disabledContentColor = ShiftTheme.colors.textInvert
                ),
                enabled = isEnabled,
                onClick = onClick
            ) {
                ShiftText(
                    text = textInButton,
                    color = ShiftTheme.colors.textInvert,
                    textStyle = TextStyle.BUTTON
                )
            }

            UiButtonStyle.FILTER -> Button(
                modifier = modifier
                    .fillMaxWidth()
                    .heightIn(min = 56.dp),
                shape = shape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = ShiftTheme.colors.textSecondary,
                    contentColor = ShiftTheme.colors.textInvert,
                    disabledContainerColor = ShiftTheme.colors.textSecondary,
                    disabledContentColor = ShiftTheme.colors.textInvert
                ),
                enabled = isEnabled,
                onClick = onClick
            ) {
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                ){
                    Icon(
                        painter = painterResource(id = R.drawable.ic_filter),
                        contentDescription = "фильтры"
                    )
                    ShiftText(
                        text = textInButton,
                        color = ShiftTheme.colors.textInvert,
                        textStyle = TextStyle.BUTTON
                    )
                }
            }

            UiButtonStyle.EMPTY -> Button(
                modifier = modifier
                    .fillMaxWidth()
                    .heightIn(min = 56.dp),
                shape = shape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = ShiftTheme.colors.backgroundPrimary,
                    contentColor = ShiftTheme.colors.textPrimary,
                    disabledContainerColor = ShiftTheme.colors.backgroundPrimary,
                    disabledContentColor = ShiftTheme.colors.textPrimary
                ),
                enabled = isEnabled,
                onClick = onClick,
                border = BorderStroke(1.dp, color = ShiftTheme.colors.borderMedium)
            ) {
                ShiftText(
                    text = textInButton,
                    color = ShiftTheme.colors.textPrimary,
                    textStyle = TextStyle.BUTTON
                )
            }
        }
        if (underButtonContent != null) {
            underButtonContent()
        }
    }
}