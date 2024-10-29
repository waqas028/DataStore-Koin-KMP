package org.waqas028.data_store_kmp.presentation.auth

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import org.waqas028.data_store_kmp.data.dto.LoginDTO
import org.waqas028.data_store_kmp.data.dto.SignUpDTO
import org.waqas028.data_store_kmp.data.model.UserPreferences
import org.waqas028.data_store_kmp.data.response.LoginData
import org.waqas028.data_store_kmp.data.response.LoginResponse
import org.waqas028.data_store_kmp.data.storage.createDataStore

class AuthVM : ViewModel() {
    private val dataStore = createDataStore()
    private val dataStoreExample = stringPreferencesKey("data_store")

    var isLoading by mutableStateOf(false)
    var error by mutableStateOf("")

    var loginResponse by mutableStateOf<LoginResponse?>(null)
    fun login(loginDTO: LoginDTO) = viewModelScope.launch {
        error = ""
        isLoading = true
        getData()
        delay(3000L)
        isLoading = false
        if (userPreference?.email == loginDTO.email && userPreference?.password == loginDTO.password) {
            loginResponse = LoginResponse(
                status = true, message = "Login Successfully", data = LoginData(
                    id = 1,
                    name = userPreference?.username,
                    email = userPreference?.email,
                    phoneNumber = userPreference?.phoneNumber,
                    createAt = "",
                    updatedAt = ""
                )
            )
            error = "Done ${userPreference?.email}"
        } else {
            error = "Invalid Credentials"
        }
    }

    var signUpResponse by mutableStateOf<LoginResponse?>(null)
    fun signUp(signUpDTO: SignUpDTO) = viewModelScope.launch {
        isLoading = true
        setData(
            UserPreferences(
                username = signUpDTO.name,
                email = signUpDTO.email,
                password = signUpDTO.password,
                phoneNumber = signUpDTO.phoneNumber
            )
        )
        getData()
        delay(3000)
        isLoading = false
        loginResponse = LoginResponse(
            status = true, message = "Login Successfully", data = LoginData(
                id = 1,
                name = userPreference?.username,
                email = userPreference?.email,
                phoneNumber = userPreference?.phoneNumber,
                createAt = "",
                updatedAt = ""
            )
        )
    }

    private var userPreference by mutableStateOf<UserPreferences?>(null)
    private fun getData() = viewModelScope.launch {
        dataStore.data.map { preferences ->
            preferences[dataStoreExample]?.let { json ->
                Json.decodeFromString(UserPreferences.serializer(), json)
            }
        }.collectLatest {
            userPreference = it
        }
    }

    private fun setData(userPreferences: UserPreferences) = viewModelScope.launch {
        dataStore.edit { preferences ->
            val json = Json.encodeToString(UserPreferences.serializer(), userPreferences)
            preferences[dataStoreExample] = json
        }
    }
}