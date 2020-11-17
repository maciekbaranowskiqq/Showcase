package com.showcase.ui.brewery

import com.showcase.common.UiMessagePresenter
import com.showcase.ui.main.MainNavigator
import javax.inject.Inject

class BreweryScreenNavigator @Inject constructor(
    private val uiMessagePresenter: UiMessagePresenter
) : MainNavigator() {

    fun navigateToCodeVerificationScreen() {
        uiMessagePresenter.showToast("Should take user to the next screen.")
    }
}