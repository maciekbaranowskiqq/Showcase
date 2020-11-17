package com.showcase.analytics

import javax.inject.Inject

internal class AnalyticsLoggerImpl @Inject constructor() : AnalyticsLogger {
    override fun initialize() = Unit
    override fun logEvent(event: Event) = Unit
}