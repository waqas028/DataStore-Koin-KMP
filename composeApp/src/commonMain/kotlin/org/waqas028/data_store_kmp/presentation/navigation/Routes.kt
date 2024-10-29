package org.waqas028.data_store_kmp.presentation.navigation

sealed class Routes(val route: String){
    data object SplashScreen : Routes("SplashScreen")
    data object LoginScreen : Routes("LoginScreen")
    data object SignUpScreen : Routes("SignUpScreen")
    data object HomeScreen : Routes("HomeScreen")
}