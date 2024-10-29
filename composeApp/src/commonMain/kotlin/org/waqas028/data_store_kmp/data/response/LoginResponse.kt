package org.waqas028.data_store_kmp.data.response

data class LoginResponse(
    val status: Boolean,
    val message: String,
    val data: LoginData?
){
    companion object
}

val LoginResponse.Companion.mockup by lazy {
    LoginResponse(status = false, message = "Done", data = LoginData.mockup)
}

data class LoginData(
    val id: Int?,
    val name: String?,
    val email: String?,
    val phoneNumber: String?,
    val createAt: String?,
    val updatedAt: String?
){
    companion object
}

val LoginData.Companion.mockup by lazy{
    LoginData(
        id = 1,
        name = "Ali",
        email = "abc@gmail.com",
        phoneNumber = "+923045593294",
        createAt = "",
        updatedAt = ""
    )
}
