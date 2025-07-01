package ru.shiftsummer2025.design_system.component.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import ru.shiftsummer2025.design_system.theme.ShiftTheme

enum class TextStyle {
    TITLE_H2,
    BUTTON,
    BODY_REGULAR_16,
}

@Composable
fun ShiftText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = ShiftTheme.colors.textPrimary,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Clip,
    textStyle: TextStyle
) {
    when (textStyle) {
        TextStyle.TITLE_H2 -> {
            Text(
                text = text,
                modifier = modifier,
                color = color,
                textAlign = textAlign,
                maxLines = maxLines,
                overflow = overflow,
                style = ShiftTheme.typography.title_h2
            )
        }

        TextStyle.BUTTON -> {
            Text(
                text = text,
                modifier = modifier,
                color = color,
                textAlign = textAlign,
                maxLines = maxLines,
                overflow = overflow,
                style = ShiftTheme.typography.button
            )
        }

        TextStyle.BODY_REGULAR_16 -> {
            Text(
                text = text,
                modifier = modifier,
                color = color,
                textAlign = textAlign,
                maxLines = maxLines,
                overflow = overflow,
                style = ShiftTheme.typography.body_regular_16
            )
        }
    }
}