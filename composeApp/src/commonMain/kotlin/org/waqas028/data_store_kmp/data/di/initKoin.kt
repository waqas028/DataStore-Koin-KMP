package org.waqas028.data_store_kmp.data.di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.waqas028.data_store_kmp.data.di.sharedModule

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(sharedModule)
    }
}