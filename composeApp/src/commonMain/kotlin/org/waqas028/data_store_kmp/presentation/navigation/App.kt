package org.waqas028.data_store_kmp.presentation.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext
import org.koin.compose.viewmodel.koinViewModel
import org.waqas028.data_store_kmp.presentation.auth.AuthVM
import org.waqas028.data_store_kmp.presentation.auth.LoginScreen
import org.waqas028.data_store_kmp.presentation.auth.SignUpScreen
import org.waqas028.data_store_kmp.presentation.home.HomeScreen
import org.waqas028.data_store_kmp.presentation.onboarding.SplashScreen

@Composable
@Preview
fun App(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    MaterialTheme {
        KoinContext {
            val authVM: AuthVM = koinViewModel()

            NavHost(
                modifier = modifier,
                navController = navController,
                startDestination = Routes.SplashScreen.route
            ) {
                composable(
                    route = Routes.SplashScreen.route,
                    enterTransition = { EnterTransition.None },
                    exitTransition = { ExitTransition.None }
                ) {
                    SplashScreen(navController)
                }

                composable(
                    route = Routes.LoginScreen.route,
                    enterTransition = { EnterTransition.None },
                    exitTransition = { ExitTransition.None }
                ) {
                    LoginScreen(navController, authVM)
                }

                composable(
                    route = Routes.SignUpScreen.route,
                    enterTransition = { EnterTransition.None },
                    exitTransition = { ExitTransition.None }
                ) {
                    SignUpScreen(navController, authVM)
                }

                composable(
                    route = Routes.HomeScreen.route,
                    enterTransition = { EnterTransition.None },
                    exitTransition = { ExitTransition.None }
                ) {
                    HomeScreen(navController)
                }
            }
        }
    }
}