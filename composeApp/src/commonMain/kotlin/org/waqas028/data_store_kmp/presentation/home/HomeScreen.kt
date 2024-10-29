package org.waqas028.data_store_kmp.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import datastore_kmp.composeapp.generated.resources.Res
import datastore_kmp.composeapp.generated.resources.email_address
import datastore_kmp.composeapp.generated.resources.log_out
import datastore_kmp.composeapp.generated.resources.name
import datastore_kmp.composeapp.generated.resources.phone_number
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel
import org.waqas028.data_store_kmp.data.model.UserPreferences
import org.waqas028.data_store_kmp.presentation.component.CustomButton
import org.waqas028.data_store_kmp.presentation.navigation.Routes

@Composable
fun HomeScreen(navController: NavController, homeVM: HomeVM = koinViewModel()){

    LaunchedEffect(Unit){
        homeVM.getData()
    }

    HomeScreen(userPreferences = homeVM.userPreference){
        homeVM.clearData()
        navController.navigate(Routes.LoginScreen.route) {
            popUpTo(navController.graph.route ?: Routes.LoginScreen.route)
        }
    }
}

@Composable
private fun HomeScreen(userPreferences: UserPreferences?, onLogoutClick: () -> Unit){
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .statusBarsPadding()
            .navigationBarsPadding()
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        Row {
            Text(
                text = "${stringResource(Res.string.name)}:",
                style = MaterialTheme.typography.subtitle2,
                color = MaterialTheme.colors.onSurface
            )
            Text(
                text = userPreferences?.username.orEmpty(),
                style = MaterialTheme.typography.subtitle2,
                color = MaterialTheme.colors.onSurface,
                modifier = Modifier.padding(start = 5.dp)
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row {
            Text(
                text = "${stringResource(Res.string.email_address)}:",
                style = MaterialTheme.typography.subtitle2,
                color = MaterialTheme.colors.onSurface
            )
            Text(
                text = userPreferences?.email.orEmpty(),
                style = MaterialTheme.typography.subtitle2,
                color = MaterialTheme.colors.onSurface,
                modifier = Modifier.padding(start = 5.dp)
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row {
            Text(
                text = "${stringResource(Res.string.phone_number)}:",
                style = MaterialTheme.typography.subtitle2,
                color = MaterialTheme.colors.onSurface
            )
            Text(
                text = userPreferences?.phoneNumber.orEmpty(),
                style = MaterialTheme.typography.subtitle2,
                color = MaterialTheme.colors.onSurface,
                modifier = Modifier.padding(start = 5.dp)
            )
        }
        Spacer(modifier = Modifier.height(30.dp))
        CustomButton(modifier = Modifier.widthIn(min = 300.dp, max = 600.dp),
            buttonText = stringResource(Res.string.log_out),
            onButtonClick = {
                onLogoutClick()
            }
        )
    }
}

@Preview
@Composable
private fun HomeScreenPreview(){
    HomeScreen(userPreferences = null){}
}