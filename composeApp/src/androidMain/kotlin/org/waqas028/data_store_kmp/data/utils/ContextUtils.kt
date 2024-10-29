package org.waqas028.data_store_kmp.data.utils

import android.content.Context

object ContextUtils {

    var dataStoreApplicationContext: Context? = null

    fun setContext(context: Context) {
        dataStoreApplicationContext = context.applicationContext
    }
}