package org.waqas028.data_store_kmp

import androidx.compose.ui.window.ComposeUIViewController
import androidx.navigation.compose.rememberNavController
import org.waqas028.data_store_kmp.data.di.initKoin
import org.waqas028.data_store_kmp.presentation.navigation.App

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) {
    val navController = rememberNavController()
    App(navController)
}