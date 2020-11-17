package com.showcase.analytics

sealed class Event(
    val description: String
) {
    data class ScreenOpen(
        val screen: Screen
    ) : Event(description = "${screen.name} Screen Opened")

    data class ButtonClick(
        val name: String,
        val screen: Screen
    ) : Event(description = "$name Button Clicked on ${screen.name} Screen")
}