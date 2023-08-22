package com.example.composesdui

import android.app.Application
import com.example.composesdui.core.di.repoModule
import com.example.composesdui.core.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ComposeSDUIApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@ComposeSDUIApplication)
            modules(
                repoModule,
                viewModelModule
            )
        }
    }
}