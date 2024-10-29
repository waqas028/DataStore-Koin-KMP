package org.waqas028.data_store_kmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform