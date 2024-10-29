package org.waqas028.data_store_kmp.data.storage

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import kotlinx.coroutines.runBlocking
import org.waqas028.data_store_kmp.data.utils.ContextUtils

actual fun createDataStore(): DataStore<Preferences> {
    return runBlocking {
        getDataStore(producePath = {
            ContextUtils.dataStoreApplicationContext!!.filesDir.resolve(
                dataStoreFileName
            ).absolutePath
        })
    }
}