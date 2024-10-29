package org.waqas028.data_store_kmp.presentation.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import datastore_kmp.composeapp.generated.resources.Res
import datastore_kmp.composeapp.generated.resources.app_name
import datastore_kmp.composeapp.generated.resources.compose_multiplatform
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.waqas028.data_store_kmp.presentation.navigation.Routes

@Composable
fun SplashScreen(navController: NavController) {
    LaunchedEffect(Unit) {
        delay(3000L)
        navController.navigate(Routes.LoginScreen.route)
    }
    SplashScreen()
}

@Composable
private fun SplashScreen() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.onPrimary)
            .statusBarsPadding()
    ) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(Res.drawable.compose_multiplatform),
                contentDescription = "Logo",
                modifier = Modifier.padding(end = 15.dp)
            )
            Spacer(modifier = Modifier.height(14.dp))
            Text(
                text = stringResource(Res.string.app_name).uppercase(),
                style = MaterialTheme.typography.h4,
                color = MaterialTheme.colors.primary,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview
@Composable
fun SplashScreenPreview() {
    SplashScreen()
}