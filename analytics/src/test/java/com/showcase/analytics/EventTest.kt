package com.showcase.analytics

import org.junit.Assert.assertEquals
import org.junit.Test

class EventTest {

    @Test
    fun `returns proper description for Screen Open event`() {
        assertEquals("${Screen.Brewery.name} Screen Opened", Event.ScreenOpen(screen = Screen.Brewery).description)
    }

    @Test
    fun `returns proper description for Button Click event`() {
        assertEquals("Continue Button Clicked on ${Screen.Brewery.name} Screen", Event.ButtonClick(name = "Continue", screen = Screen.Brewery).description)
    }
}