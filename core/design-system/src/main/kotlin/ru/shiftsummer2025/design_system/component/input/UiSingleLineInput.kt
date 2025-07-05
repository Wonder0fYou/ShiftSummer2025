package ru.shiftsummer2025.design_system.component.input

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import ru.shiftsummer2025.design_system.component.iconItem.ActionIconItem
import ru.shiftsummer2025.design_system.component.text.ShiftText
import ru.shiftsummer2025.design_system.component.text.TextStyle
import ru.shiftsummer2025.design_system.theme.ShiftTheme

@Composable
fun UiSingleLineInput(
    modifier: Modifier = Modifier,
    text: String,
    labelText: String? = null,
    placeholderText: String? = null,
    shape: RoundedCornerShape = RoundedCornerShape(10.dp),
    trailingIconItem: ActionIconItem? = null,
    singleLine: Boolean = true,
    readOnly: Boolean = false,
    onTextChange: (String) -> Unit,
) {
    Column(
        modifier = modifier
            .wrapContentSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        if (labelText != null) {
            ShiftText(
                text = labelText,
                color = ShiftTheme.colors.textPrimary,
                textStyle = TextStyle.BODY_REGULAR_14
            )
        }
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = text,
            singleLine = singleLine,
            shape = shape,
            readOnly = readOnly,
            placeholder = placeholderText?.let {
                {
                    ShiftText(
                        text = placeholderText,
                        color = ShiftTheme.colors.borderMedium,
                        textStyle = TextStyle.BODY_REGULAR_16
                    )
                }
            },
            onValueChange = {
                onTextChange(it)
            },
            trailingIcon = trailingIconItem?.let {
                {
                    IconButton(onClick = it.onClick) {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = it.iconRes),
                            contentDescription = it.contentDescription
                        )
                    }
                }
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = ShiftTheme.colors.backgroundPrimary,
                unfocusedContainerColor = ShiftTheme.colors.backgroundPrimary,
                focusedPlaceholderColor = ShiftTheme.colors.borderMedium,
                unfocusedPlaceholderColor = ShiftTheme.colors.borderMedium,
                focusedTextColor = ShiftTheme.colors.textPrimary,
                unfocusedTextColor = ShiftTheme.colors.textTertiary,
                errorBorderColor = ShiftTheme.colors.borderMedium,
                errorContainerColor = ShiftTheme.colors.borderMedium,
                focusedBorderColor = ShiftTheme.colors.borderMedium,
                unfocusedBorderColor = ShiftTheme.colors.borderMedium,
                errorPlaceholderColor = ShiftTheme.colors.borderMedium,
            ),
        )
    }
}