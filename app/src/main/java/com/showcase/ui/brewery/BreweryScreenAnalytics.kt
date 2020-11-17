package com.showcase.ui.brewery

import com.showcase.analytics.AnalyticsLogger
import com.showcase.analytics.Event
import com.showcase.analytics.Screen
import javax.inject.Inject

class BreweryScreenAnalytics @Inject constructor(
    private val analyticsLogger: AnalyticsLogger
) {
    fun logInteraction(interaction: BreweryScreenInteractions) {
        analyticsLogger.logEvent(interaction.toEvent())
    }

    private fun BreweryScreenInteractions.toEvent(): Event = when (this) {
        is BreweryScreenInteractions.ScreenEntered -> Event.ScreenOpen(screen = Screen.Brewery)
        is BreweryScreenInteractions.ContinueButtonClicked -> Event.ButtonClick(name = "Continue", screen = Screen.Brewery)
    }
}