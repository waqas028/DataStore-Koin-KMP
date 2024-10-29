package org.waqas028.data_store_kmp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import org.waqas028.data_store_kmp.data.utils.ContextUtils
import org.waqas028.data_store_kmp.presentation.navigation.App

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ContextUtils.setContext(context = this)
        setContent {
            val navController = rememberNavController()
            App(navController)
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    val navController = rememberNavController()
    App(navController)
}