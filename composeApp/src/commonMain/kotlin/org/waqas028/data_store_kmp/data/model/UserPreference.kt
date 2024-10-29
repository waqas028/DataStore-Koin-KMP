package org.waqas028.data_store_kmp.data.model

import kotlinx.serialization.Serializable

@Serializable
data class UserPreferences(
    val username: String,
    val email: String,
    val phoneNumber: String,
    val password: String?,
)