package bz.micro.si4

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import bz.micro.si4.models.ViewController
import bz.micro.si4.screens.Login
import bz.micro.si4.screens.Splash


sealed class Screen (var route:String)  {
    object Splash : Screen("Splash")
    object Login : Screen("Login")
    object DocList : Screen("DocList")
    object PosList : Screen("PosList")
    object Position : Screen("Position")
    object Settings : Screen("Settings")
}

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun NavigationGraphTest(navController:NavHostController, viewController: ViewController) {
    NavHost(navController = navController, startDestination = viewController.defaultScreen) {
        composable(Screen.Splash.route) { Splash(navController = navController, view = viewController ) }
        composable(Screen.Login.route) { Login(navController,viewController) }
        composable(Screen.DocList.route) {  }
        composable(Screen.PosList.route) {  }
        composable(Screen.Position.route) {  }
        composable(Screen.Settings.route) {  }
    }
}