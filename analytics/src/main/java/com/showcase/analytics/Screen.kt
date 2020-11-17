package com.showcase.analytics

sealed class Screen(
    val name: String
) {
    object Brewery : Screen("Brewery")
}