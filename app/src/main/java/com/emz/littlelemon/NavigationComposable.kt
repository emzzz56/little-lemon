package com.emz.littlelemon

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.MutableLiveData
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MyNavigation(){
    val context = LocalContext.current
    val navController = rememberNavController()
    val firstName = MutableLiveData<String>()
    val lastName = MutableLiveData<String>()
    val email = MutableLiveData<String>()
    val sharedPreferences by lazy {
        context.getSharedPreferences("LittleLemon", Activity.MODE_PRIVATE)
    }
    firstName.value = sharedPreferences.getString("firstName", "")
    lastName.value = sharedPreferences.getString("lastName", "")
    email.value = sharedPreferences.getString("email", "")
    var defaultRoute = Onboarding.route
    if(firstName.value?.isNotBlank()!! && lastName.value?.isNotBlank()!! && email.value?.isNotBlank()!!){
        defaultRoute = Home.route
    }
    NavHost(
        navController = navController,
        startDestination = defaultRoute
    ) {
        composable(Home.route) {
            Home(navController = navController)
        }
        composable(Profile.route) {
            Profile(navController = navController)
        }
        composable(Onboarding.route){
            onBoarding(navController = navController)
        }

    }
}