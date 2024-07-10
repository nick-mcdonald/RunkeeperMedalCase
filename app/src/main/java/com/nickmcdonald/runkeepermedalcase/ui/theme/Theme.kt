package com.nickmcdonald.runkeepermedalcase.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val RunKeeperDarkColorScheme = darkColorScheme(
    primary = Color(0xFFFFFFFF),
    secondary = Color(0xFF848484),
    tertiary = Color(0xFF444444)
)

private val RunKeeperLightColorScheme = lightColorScheme(
    primary = PrimaryColor,
    onPrimary = PrimaryFontColor,
    primaryContainer = PrimaryColor,
    onPrimaryContainer = PrimaryFontColor,
    secondaryContainer = HeaderColor,
    onSecondaryContainer = HeaderFontColor,
    onTertiaryContainer = HeaderSecondaryColor,
    background = SurfaceColor,
    onBackground = SurfaceFontColor,
    surface = SurfaceColor,
    onSurface = SurfaceFontColor,

    /* Theme default color keys
    primaryContainer
    onPrimaryContainer
    secondary
    onSecondary

    tertiary
    onTertiary
    tertiaryContainer
    onTertiaryContainer

    error
    errorContainer
    onError
    onErrorContainer
    surfaceVariant
    onSurfaceVariant
    outline
    inverseOnSurface
    inverseSurface
    inversePrimary
    surfaceTint
    outlineVariant
    scrim
    */
)

@Composable
fun RunKeeperMedalCaseTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) RunKeeperDarkColorScheme else RunKeeperLightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = RunKeeperTypography,
        content = content
    )
}