package com.showcase

import android.app.Application
import com.showcase.analytics.AnalyticsLogger
import com.showcase.common.MainActivityProvider
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class App : Application() {

    @Inject
    lateinit var mainActivityProvider: MainActivityProvider

    @Inject
    lateinit var analyticsLogger: AnalyticsLogger

    override fun onCreate() {
        super.onCreate()
        registerToLifecycle()
        analyticsLogger.initialize()
    }

    private fun registerToLifecycle() {
        mainActivityProvider.register(this)
    }
}
