package bz.micro.si4.screens

import android.content.res.Configuration
import android.os.Build

import androidx.activity.compose.BackHandler
import androidx.annotation.RequiresApi

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.graphics.ExperimentalAnimationGraphicsApi
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text

import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier

import androidx.compose.ui.platform.LocalConfiguration


import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.constraintlayout.compose.MotionLayout
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import bz.micro.si4.R
import bz.micro.si4.models.ViewController
import bz.micro.si4.screens.layouts.loginLayoutLandscape
import bz.micro.si4.screens.layouts.loginLayoutPortrait
import bz.micro.si4.ui.theme.SysColors
import kotlinx.coroutines.launch
import kotlin.random.Random


@RequiresApi(Build.VERSION_CODES.P)
@OptIn(ExperimentalMotionApi::class, ExperimentalAnimationGraphicsApi::class)
//@OptIn(ExperimentalAnimationGraphicsApi::class)
@Composable
fun Login (navController: NavController, viewMod: ViewController = viewModel()) {
    val configuration = LocalConfiguration.current
    val portrait by rememberSaveable { mutableStateOf(configuration.orientation == Configuration.ORIENTATION_PORTRAIT) }
    val scope = rememberCoroutineScope()
//    var rawData:RawData

    val animationProgress by animateFloatAsState(
        targetValue = if (portrait) 1f else 0f,
        animationSpec = tween(900)
    )

    val state = remember { mutableStateOf(true) }
//    val painter = rememberAnimatedVectorPainter(animatedImageVector = AnimatedImageVector.animatedVectorResource(
//        R.drawable.hamburger),state.value)


    SysColors(
        MaterialTheme.colors.background,
        MaterialTheme.colors.background,
        dark = !isSystemInDarkTheme()
    )

    BackHandler(true) {
    }

//    LaunchedEffect(key1 = configuration.orientation, key2 = socketData) {
//        Log.d("Socket", socketData)
//        this.launch {
//            portrait = configuration.orientation == Configuration.ORIENTATION_PORTRAIT
//        }
//    }


    MotionLayout(
        modifier = Modifier.fillMaxSize(),
        start = ConstraintSet(loginLayoutLandscape),
        end = ConstraintSet(loginLayoutPortrait),
        progress = animationProgress
    )
    {


//
//if (userListIsEmpty)  {
//    MobileEdit(
//        modifier= Modifier
//            .fillMaxWidth()
//            .padding(start = 50.dp, end = 50.dp),
//        layoutId = "LoginEdt",
//        errorId = "LoginErr",
//        placeholder = { Text("login placeholder")},
//        label = { Text("login label")},
//        Result = {
//            Log.d("login: ", it)
//        }
//        )
//
//}
// else {
//
//// select user from
//        Box(
//            modifier = Modifier
//                .clip(RoundedCornerShape(150.dp, 150.dp, 150.dp, 150.dp))
//                .background(MaterialTheme.colors.primary)
//                .width(88.dp)
//                .height(88.dp)
//                .layoutId("UserPhoto")
//        )
//        // User Header
//        Text(modifier = Modifier.layoutId("Hello"), text = "Hello,", style =  MaterialTheme.typography.h1)
//        Text(modifier = Modifier.layoutId("UserName"), text = "Alexander", style =  MaterialTheme.typography.h1)
//
//
//
//    }
//
//
//        PasswordEdit(modifier = Modifier
//            .fillMaxWidth()
//            .padding(start = 50.dp, end = 50.dp),
//            layoutId = "PasswordEdt",
//            ErrorId = "PasswordErr",
//            label = {Text ("password label")},
//            placeholder = {Text ("password placeholder")},
//            Result = {
//                Log.d("password: ", it)
//
//            } )
//        Text(text = "", modifier = Modifier.layoutId("Center"))
//
//
//        Icon(
//            modifier = Modifier
//                .layoutId("Shield")
//                .clickable {
//                    scope.launch { viewMod.openSocket() }
//
//                },
//            painter = painterResource(id = R.drawable.shield), contentDescription = "",
//            tint = MaterialTheme.colors.primary)
//        Text(text = "Защита данных", modifier = Modifier.layoutId("ShieldText"))
//
//        Icon(
//            modifier = Modifier
//                .layoutId("QRcode")
//                .clickable {
//                    scope.launch {
//                        viewMod.sendSocket(
//                            """{"Request": "string", "Param":${
//                                Random.nextInt(
//                                    0,
//                                    100
//                                )
//                            }} """
//                        )
//                    }
//
//                },
//            painter = painterResource(id = R.drawable.qr_code), contentDescription = "",
//            tint = MaterialTheme.colors.primary)
//        Text(text = "Поделиться приложением", modifier = Modifier.layoutId("QRcodeText"))
//
//        Icon(
//            modifier = Modifier
//                .layoutId("PhoneCall")
//                .clickable {
//                    navController.navigate(Screen.Photo.route)
//                },
//            painter = painterResource(id = R.drawable.phone_call), contentDescription = "",
//            tint = MaterialTheme.colors.primary)
//        Text(text = "Звонок в поддержку", modifier = Modifier.layoutId("PhoneCallText"))
//
//
////    Text(text = "Local user ", modifier = Modifier.layoutId("UserPhoto") )
//
//    }
        Text("Login")
    }
}

