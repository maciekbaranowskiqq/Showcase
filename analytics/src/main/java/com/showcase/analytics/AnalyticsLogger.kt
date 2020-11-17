package com.showcase.analytics

interface AnalyticsLogger {
    fun initialize()
    fun logEvent(event: Event)
}