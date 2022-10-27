package bz.micro.si4.screens

import android.Manifest
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.navigation.NavController
import bz.micro.si4.R
import bz.micro.si4.Screen
import bz.micro.si4.models.ViewController
import bz.micro.si4.ui.theme.SysColors
import bz.micro.si4.ui.theme.blue
import bz.micro.si4.screens.layouts.splashLayout
import bz.micro.si4.screens.layouts.splashLayoutFront
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import kotlinx.coroutines.launch


@RequiresApi(Build.VERSION_CODES.S)
@OptIn(ExperimentalPermissionsApi::class, ExperimentalMaterialApi::class)
@Composable
fun Splash(navController: NavController, view: ViewController) {
    val scope = rememberCoroutineScope()
//    var navColor :Color  = blue
//    var statColor:Color = blue
    val configuration = LocalConfiguration.current
//    val context = LocalContext.current

  var headerHeight = 0.dp


    val multiplePermissionsState = rememberMultiplePermissionsState(
            listOf(
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.CAMERA,
                Manifest.permission.READ_PHONE_STATE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE



                ))


    val backdropScaffoldState = rememberBackdropScaffoldState(if (multiplePermissionsState.allPermissionsGranted) BackdropValue.Revealed else BackdropValue.Concealed )

    LaunchedEffect(key1 = true,
                   key2 = multiplePermissionsState.allPermissionsGranted,
                   key3 = view.location,
    ) {

        if (view.location != null) {
            Log.d("Location",view.location.toString())
        }


        if (multiplePermissionsState.allPermissionsGranted) {
            scope.launch {
                backdropScaffoldState.reveal()
//                statColor = blue
//                navColor = blue
                scope.launch { navController.navigate(Screen.Login.route) }

            }
        } else {
            headerHeight = 5.dp
            backdropScaffoldState.conceal()

        }

    }
    SysColors(StatusColor = blue ,
        NavigationColor = blue,true)

    BackdropScaffold(
        appBar = {},
        backLayerContent = {
            ConstraintLayout(
                ConstraintSet(splashLayout),
                modifier = Modifier
                    .fillMaxSize()
                    .background(blue)

            ) {
                Icon(
                    modifier = Modifier
                        .layoutId("Logo"),
//                        .padding(bottom = (configuration.screenHeightDp/2).dp),
                    tint = White,
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = ""
                )
                Text(
                    modifier = Modifier
                        .layoutId("Text"),
                    color = White,
                        text = "Loading"
                    )


//        Text(modifier = Modifier.layoutId("Logo"), text = "Splash")
            }
        },
        scaffoldState = backdropScaffoldState,
        frontLayerContent = {
            ConstraintLayout(
                ConstraintSet(splashLayoutFront),
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colors.onError))
            {

                Text("I need permissions for work...",
                    modifier = Modifier.layoutId("Text"))
                Button(  modifier = Modifier.layoutId("Button"),
                    onClick = {
                        multiplePermissionsState.launchMultiplePermissionRequest()
                    })
                { Text("Grant permissions", color = MaterialTheme.colors.background) }
            }


        },
        frontLayerElevation = 2.dp,
        frontLayerShape = MaterialTheme.shapes.small,
        headerHeight = headerHeight,
        peekHeight =  (configuration.screenHeightDp/2).dp,
        gesturesEnabled = false

    )
}



