package com.showcase.ui.brewery

import com.showcase.analytics.AnalyticsLogger
import com.showcase.ui.brewery.BreweryScreenInteractions.ContinueButtonClicked
import com.showcase.ui.brewery.BreweryScreenInteractions.ScreenEntered
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.Before
import org.junit.Test

class BreweryScreenAnalyticsTest {
    private lateinit var subject: BreweryScreenAnalytics

    @RelaxedMockK
    private lateinit var mockedAnalyticsLogger: AnalyticsLogger

    @Before
    fun setUp() {
        MockKAnnotations.init(this)

        subject = BreweryScreenAnalytics(
            analyticsLogger = mockedAnalyticsLogger
        )
    }

    @Test
    fun `logs Brewery Screen Open event`() {
        subject.logInteraction(ScreenEntered)

        verify { mockedAnalyticsLogger.logEvent(match { it.description == "Brewery Screen Opened" }) }
    }

    @Test
    fun `logs Continue Button Click event`() {
        subject.logInteraction(ContinueButtonClicked)

        verify { mockedAnalyticsLogger.logEvent(match { it.description == "Continue Button Clicked on Brewery Screen" }) }
    }
}
