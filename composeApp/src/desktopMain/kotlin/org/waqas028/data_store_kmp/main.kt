package org.waqas028.data_store_kmp

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.navigation.compose.rememberNavController
import org.waqas028.data_store_kmp.data.di.initKoin
import org.waqas028.data_store_kmp.presentation.navigation.App

fun main() = application {
    initKoin()
    Window(
        onCloseRequest = ::exitApplication,
        title = "DataStore-KMP",
    ) {
        val navController = rememberNavController()
        App(navController)
    }
}