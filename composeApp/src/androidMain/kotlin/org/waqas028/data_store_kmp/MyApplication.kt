package org.waqas028.data_store_kmp

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.waqas028.data_store_kmp.data.di.initKoin

class MyApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@MyApplication)
        }
    }
}
