package org.waqas028.data_store_kmp.presentation.home

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

class HomeVM : ViewModel() {
    private val dataStore = createDataStore()
    private val dataStoreExample = stringPreferencesKey("data_store")

    var isLoading by mutableStateOf(false)
    var error by mutableStateOf("")

    var userPreference by mutableStateOf<UserPreferences?>(null)
    fun getData() = viewModelScope.launch {
        dataStore.data.map { preferences ->
            preferences[dataStoreExample]?.let { json ->
                Json.decodeFromString(UserPreferences.serializer(), json)
            }
        }.collectLatest {
            userPreference = it
        }
    }

    fun clearData() = viewModelScope.launch {
        dataStore.edit { preferences ->
            preferences.remove(dataStoreExample)
        }
    }
}