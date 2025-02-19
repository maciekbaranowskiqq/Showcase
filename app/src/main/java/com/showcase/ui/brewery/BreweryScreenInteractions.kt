package com.showcase.ui.brewery

sealed class BreweryScreenInteractions {
    object ScreenEntered : BreweryScreenInteractions()
    object ContinueButtonClicked : BreweryScreenInteractions()
}