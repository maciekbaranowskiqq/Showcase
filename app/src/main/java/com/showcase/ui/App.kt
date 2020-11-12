package com.showcase.ui

import android.app.Application
import com.showcase.common.MainActivityProvider
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class App : Application() {

    @Inject
    lateinit var mainActivityProvider: MainActivityProvider

    override fun onCreate() {
        super.onCreate()
        registerToLifecycle()
    }

    private fun registerToLifecycle() {
        mainActivityProvider.register(this)
    }
}
