package ru.shiftsummer2025.design_system.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class ShiftColorScheme(
    // Background
    val backgroundPrimary: Color,
    val backgroundSecondary: Color,
    val backgroundTertiary: Color,
    val backgroundDisabled: Color,

    // Border
    val borderExtraLight: Color,
    val borderLight: Color,
    val borderMedium: Color,

    // Text
    val textInvert: Color,
    val textPrimary: Color,
    val textSecondary: Color,
    val textTertiary: Color,
    val textQuaternary: Color,
    val textError: Color,

    // Indicator
    val indicatorWhite: Color,
    val indicatorLight: Color,
    val indicatorMedium: Color,
    val indicatorNormal: Color,
    val indicatorError: Color,
    val indicatorAttention: Color,
    val indicatorPositive: Color,

    // Brand Leasing
    val brandLeasingPrimary: Color,
    val brandLeasingPressed: Color,
    val brandLeasingHover: Color,
    val brandLeasingExtraLight: Color,
    val brandLeasingDisabled: Color,
    val brandLeasingIndicatorFocused: Color,
    val brandLeasingIndicatorFocusedAlternative: Color
)

private val LightColorScheme = ShiftColorScheme(
    // Background
    backgroundPrimary = BG_Primary,
    backgroundSecondary = BG_Secondary,
    backgroundTertiary = BG_Tertiary,
    backgroundDisabled = BG_Disable,

    // Border
    borderExtraLight = Border_ExtraLight,
    borderLight = Border_Light,
    borderMedium = Border_Medium,

    // Text
    textInvert = Text_Invert,
    textPrimary = Text_Primary,
    textSecondary = Text_Secondary,
    textTertiary = Text_Tertiary,
    textQuaternary = Text_Quartenery,
    textError = Text_Error,

    // Indicator
    indicatorWhite = Indicator_White,
    indicatorLight = Indicator_Light,
    indicatorMedium = Indicator_Medium,
    indicatorNormal = Indicator_Normal,
    indicatorError = Indicator_Error,
    indicatorAttention = Indicator_Attention,
    indicatorPositive = Indicator_Positive,

    // Brand Leasing
    brandLeasingPrimary = Leasing_Brand,
    brandLeasingPressed = Leasing_Pressed_Primary,
    brandLeasingHover = Leasing_Hover_Primary,
    brandLeasingExtraLight = Leasing_Brand_ExtraLight,
    brandLeasingDisabled = Leasing_Brand_Disabled,
    brandLeasingIndicatorFocused = Leasing_Indicator_Focused,
    brandLeasingIndicatorFocusedAlternative = Leasing_Indicator_Focused_alternative
)

private val DarkColorScheme = ShiftColorScheme(
    // Background
    backgroundPrimary = BG_Primary,
    backgroundSecondary = BG_Secondary,
    backgroundTertiary = BG_Tertiary,
    backgroundDisabled = BG_Disable,

    // Border
    borderExtraLight = Border_ExtraLight,
    borderLight = Border_Light,
    borderMedium = Border_Medium,

    // Text
    textInvert = Text_Invert,
    textPrimary = Text_Primary,
    textSecondary = Text_Secondary,
    textTertiary = Text_Tertiary,
    textQuaternary = Text_Quartenery,
    textError = Text_Error,

    // Indicator
    indicatorWhite = Indicator_White,
    indicatorLight = Indicator_Light,
    indicatorMedium = Indicator_Medium,
    indicatorNormal = Indicator_Normal,
    indicatorError = Indicator_Error,
    indicatorAttention = Indicator_Attention,
    indicatorPositive = Indicator_Positive,

    // Brand Leasing
    brandLeasingPrimary = Leasing_Brand,
    brandLeasingPressed = Leasing_Pressed_Primary,
    brandLeasingHover = Leasing_Hover_Primary,
    brandLeasingExtraLight = Leasing_Brand_ExtraLight,
    brandLeasingDisabled = Leasing_Brand_Disabled,
    brandLeasingIndicatorFocused = Leasing_Indicator_Focused,
    brandLeasingIndicatorFocusedAlternative = Leasing_Indicator_Focused_alternative
)

private val LocalColors = staticCompositionLocalOf { LightColorScheme }
private val LocalTypography = staticCompositionLocalOf { ShiftTypographySet }

@Composable
fun ShiftSummer2025Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val typography = ShiftTypographySet
    CompositionLocalProvider(
        LocalColors provides colors,
        LocalTypography provides typography,
        content = content
    )
}

object ShiftTheme {
    val colors: ShiftColorScheme
        @Composable @ReadOnlyComposable
        get() = LocalColors.current
    val typography: ShiftTypography
        @Composable @ReadOnlyComposable
        get() = LocalTypography.current
}