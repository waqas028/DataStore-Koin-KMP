package org.waqas028.data_store_kmp.data.utils


fun isValidEmail(email: String): Boolean {
    val emailPattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$".toRegex()
    return emailPattern.matches(email)
}

fun isNameValid(name: String): Pair<Boolean, String?> {
    return when {
        name.isBlank() -> Pair(false, "Name cannot be empty.")
        name.length > 50 -> Pair(false, "Name cannot exceed 50 characters.")
        !name.matches(Regex("^[a-zA-Z\\s-]+$")) -> Pair(
            false,
            "Name can only contain letters, spaces, and hyphens."
        )

        else -> Pair(true, null) // Valid name
    }
}

fun isValidPhoneNumber(phone: String): Boolean {
    val phonePattern = "^\\+?[1-9]\\d{1,14}\$"
    return phone.matches(phonePattern.toRegex())
}

fun isPasswordValid(password: String): Pair<Boolean, String?> {
    return when {
        password.length < 8 -> Pair(false, "Password must be at least 8 characters long.")
        !password.any { it.isUpperCase() } -> Pair(
            false,
            "Password must contain at least one uppercase letter."
        )

        !password.any { it.isLowerCase() } -> Pair(
            false,
            "Password must contain at least one lowercase letter."
        )

        !password.any { it.isDigit() } -> Pair(false, "Password must contain at least one digit.")
        else -> Pair(true, null) // Valid password
    }
}