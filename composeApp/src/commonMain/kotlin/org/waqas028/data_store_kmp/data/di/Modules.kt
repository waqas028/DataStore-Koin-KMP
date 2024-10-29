@file:Suppress("DEPRECATION")

package org.waqas028.data_store_kmp.data.di

import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import org.waqas028.data_store_kmp.presentation.auth.AuthVM
import org.waqas028.data_store_kmp.presentation.home.HomeVM

val sharedModule = module {
    viewModelOf(::AuthVM)
    viewModelOf(::HomeVM)
}