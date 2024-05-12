package com.blackhand.moviekmp.android

import android.app.Application
import com.blackhand.moviekmp.android.di.appModule
import com.blackhand.moviekmp.data.di.getSharedModule
import org.koin.core.context.startKoin

class Movie : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule + getSharedModule())
        }
    }
}