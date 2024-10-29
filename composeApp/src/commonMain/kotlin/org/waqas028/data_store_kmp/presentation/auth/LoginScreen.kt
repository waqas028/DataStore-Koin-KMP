package org.waqas028.data_store_kmp.presentation.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import datastore_kmp.composeapp.generated.resources.Res
import datastore_kmp.composeapp.generated.resources.add_your_account_to_ventagram
import datastore_kmp.composeapp.generated.resources.create_an_account
import datastore_kmp.composeapp.generated.resources.email_address
import datastore_kmp.composeapp.generated.resources.enter_your_email_address
import datastore_kmp.composeapp.generated.resources.enter_your_password
import datastore_kmp.composeapp.generated.resources.forget_password
import datastore_kmp.composeapp.generated.resources.ic_or_divider
import datastore_kmp.composeapp.generated.resources.not_a_member
import datastore_kmp.composeapp.generated.resources.password
import datastore_kmp.composeapp.generated.resources.sign_in
import datastore_kmp.composeapp.generated.resources.sign_in_to_your_account
import datastore_kmp.composeapp.generated.resources.sign_in_with_google
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel
import org.waqas028.data_store_kmp.data.dto.LoginDTO
import org.waqas028.data_store_kmp.data.model.UserPreferences
import org.waqas028.data_store_kmp.data.utils.isValidEmail
import org.waqas028.data_store_kmp.presentation.component.CustomButton
import org.waqas028.data_store_kmp.presentation.component.CustomCircularProgressBar
import org.waqas028.data_store_kmp.presentation.component.GoogleButton
import org.waqas028.data_store_kmp.presentation.component.PasswordTextFields
import org.waqas028.data_store_kmp.presentation.component.TextFieldWithIcon
import org.waqas028.data_store_kmp.presentation.navigation.Routes

@Composable
fun LoginScreen(navController: NavController, authVM: AuthVM = koinViewModel()) {
    val error = authVM.error
    val loginResponse = authVM.loginResponse

    LaunchedEffect(loginResponse) {
        loginResponse?.let {
            println(it)
            if (it.status) navController.navigate(Routes.HomeScreen.route) {
                popUpTo(navController.graph.route ?: Routes.LoginScreen.route)
            }
            authVM.loginResponse = null
        }
    }

    LoginScreen(
        isLoading = authVM.isLoading,
        error = authVM.error,
        onSignInClick = { loginDTO ->
            authVM.login(loginDTO)
        },
        onSignUpClick = { navController.navigate(Routes.SignUpScreen.route) },
    )
}

@Composable
fun LoginScreen(
    isLoading: Boolean,
    error: String,
    onSignInClick: (LoginDTO) -> Unit,
    onSignUpClick: () -> Unit,
) {  
    var emailAddress by rememberSaveable { mutableStateOf("") }
    var emailErrorMessage by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var passwordErrorMessage by rememberSaveable { mutableStateOf(error) }
    var passwordVisibility by remember { mutableStateOf(false) }

    LaunchedEffect(error){
        passwordErrorMessage = error
    }

    Box(
        modifier = Modifier.fillMaxSize().background(Color.LightGray)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .navigationBarsPadding()
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = stringResource(Res.string.sign_in_to_your_account),
                style = MaterialTheme.typography.h3,
                color = MaterialTheme.colors.onSurface,
                modifier = Modifier.padding(start = 15.dp, top = 61.dp, end = 15.dp)
            )
            Text(
                text = stringResource(Res.string.add_your_account_to_ventagram),
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onSurface.copy(alpha = 0.6f),
                modifier = Modifier.padding(start = 15.dp, end = 15.dp, top = 9.dp)
            )
            Spacer(modifier = Modifier.height(30.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colors.background).padding(horizontal = 15.dp)
            ) {
                Spacer(modifier = Modifier.height(28.dp))
                Text(
                    text = stringResource(Res.string.email_address),
                    style = MaterialTheme.typography.subtitle2,
                    color = MaterialTheme.colors.onSurface
                )
                TextFieldWithIcon(placeholder = stringResource(Res.string.enter_your_email_address),
                    textValue = emailAddress,
                    errorMessage = emailErrorMessage,
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Email,
                            tint = MaterialTheme.colors.primary,
                            contentDescription = "Email"
                        )
                    }) {
                    emailAddress = it
                }
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = stringResource(Res.string.password),
                    style = MaterialTheme.typography.subtitle1,
                    color = MaterialTheme.colors.onSurface
                )
                PasswordTextFields(placeholder = stringResource(Res.string.enter_your_password),
                    password = password,
                    passwordVisibility = passwordVisibility,
                    errorMessage = passwordErrorMessage,
                    onTextChange = { password = it },
                    onToggleClick = { passwordVisibility = it })
                Text(
                    text = stringResource(Res.string.forget_password),
                    textDecoration = TextDecoration.Underline,
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.primaryVariant,
                    textAlign = TextAlign.End,
                    modifier = Modifier.align(Alignment.End).padding(top = 11.dp)
                )
                Spacer(modifier = Modifier.height(40.dp))
                CustomButton(modifier = Modifier.widthIn(min = 300.dp, max = 600.dp),
                    buttonText = stringResource(Res.string.sign_in),
                    onButtonClick = {
                        if (emailAddress.trim().isEmpty()) {
                            emailErrorMessage = "Please enter email address"
                            passwordErrorMessage = ""
                        }else if (!isValidEmail(emailAddress.trim())) {
                            emailErrorMessage = "Please enter valid email address"
                            passwordErrorMessage = ""
                        }else if(password.trim().isEmpty()){
                            passwordErrorMessage = "Please enter password"
                            emailErrorMessage = ""
                        } else onSignInClick(LoginDTO(email = emailAddress, password = password))
                    })
                Spacer(modifier = Modifier.height(30.dp))
                Image(
                    painter = painterResource(Res.drawable.ic_or_divider),
                    contentDescription = "or divider"
                )
                GoogleButton(
                    modifier = Modifier.widthIn(min = 300.dp, max = 600.dp).padding(top = 30.dp),
                    buttonText = stringResource(Res.string.sign_in_with_google)
                ) {}
                Row(
                    modifier = Modifier.fillMaxSize().padding(vertical = 30.dp),
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = stringResource(Res.string.not_a_member),
                        style = MaterialTheme.typography.body1,
                        color = MaterialTheme.colors.secondary
                    )
                    Text(text = stringResource(Res.string.create_an_account),
                        textDecoration = TextDecoration.Underline,
                        style = MaterialTheme.typography.body1,
                        fontWeight = FontWeight.ExtraBold,
                        color = MaterialTheme.colors.onSurface,
                        modifier = Modifier
                            .padding(start = 5.dp)
                            .clickable {
                                onSignUpClick()
                            }
                    )
                }
            }
        }
        if (isLoading) CustomCircularProgressBar()
    }
}


@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen(isLoading = true, error = "", onSignInClick = {}, onSignUpClick = {})
}