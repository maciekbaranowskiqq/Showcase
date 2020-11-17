package com.showcase.analytics

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@InstallIn(ApplicationComponent::class)
@Module
internal interface AnalyticsModule {
    @Binds
    fun bindsAnalyticsLogger(analyticsLogger: AnalyticsLoggerImpl): AnalyticsLogger
}
