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
import org.waqas028.data_store_kmp.presentation.auth.LoginScreen
import org.waqas028.data_store_kmp.presentation.onboarding.SplashScreen

@Composable
@Preview
fun App(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    MaterialTheme {
        KoinContext {
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
                    LoginScreen(navController)
                }
            }
        }
    }
}