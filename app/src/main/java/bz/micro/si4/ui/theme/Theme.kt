package bz.micro.si4.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import com.google.accompanist.systemuicontroller.rememberSystemUiController





private val DarkColorPalette = darkColors(
    primary = White,
    onPrimary = lblue,
    primaryVariant = Purple700,
    secondary = Teal200,
    background = blue,
    onBackground = White,
    error = red,
    onError = White
)

private val LightColorPalette = lightColors(
    primary = blue,
    onPrimary = lblue,
    primaryVariant = bluePrimary,
    secondary = Teal200,
    background = White,
    onBackground = blue,
    error = red,
    onError = White

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun Si4Theme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}


@Composable
fun SysColors(StatusColor: Color, NavigationColor: Color, dark:Boolean){
    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(
        color = StatusColor,
        darkIcons = dark,
        transformColorForLightContent = {White}
    )
    systemUiController.setNavigationBarColor(
        color = NavigationColor,
        darkIcons = dark,
        navigationBarContrastEnforced = true
    )

}