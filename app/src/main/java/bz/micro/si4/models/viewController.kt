package bz.micro.si4.models

import android.Manifest
import android.app.Application
import android.app.Service
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.core.app.ActivityCompat
import androidx.lifecycle.AndroidViewModel
import bz.micro.si4.Screen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ViewController(application: Application): AndroidViewModel(application) {

    private val _connected = MutableStateFlow(false)
    val connected: StateFlow<Boolean> = _connected
    suspend fun setConnected(state: Boolean) {
        _connected.emit(state)
    }

    private val _logged = MutableStateFlow(false)
    val logged: StateFlow<Boolean> = _logged
    suspend fun setLogged(state: Boolean) {
        _logged.emit(state)
    }

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading
    suspend fun setLoading(state: Boolean) {
        _loading.emit(state)
    }

    var location:Location? = null

    var defaultScreen = (Screen.Splash.route)

    var locationManager: LocationManager = application.getSystemService(Service.LOCATION_SERVICE) as LocationManager
    private val locationListener: LocationListener = LocationListener { p0 ->
   //     val s = "speed: ${p0.speed}, alt: ${p0.altitude}, lng: ${p0.longitude}, lat: ${p0.latitude} "
        location = p0
    }

    init {
        if (ActivityCompat.checkSelfPermission(
                application,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                application,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10000L,10f,locationListener)
        }

//        database = DB.getDatabase(application)
//        val repository = UserRepository(database.userDao())
//
//        if (repository.isEmpty()) {
//            viewModelScope.launch { setUsersEmpty(true) }
//        } else {
//            viewModelScope.launch {
//                currentUser = repository.lastUser()
//                setUsersEmpty(false)
//            }
//        }


    } // init finish

}