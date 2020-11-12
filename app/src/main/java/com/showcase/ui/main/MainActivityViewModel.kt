package com.showcase.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.showcase.common.UiMessagePresenter

class MainActivityViewModel @ViewModelInject constructor(
    private val uiMessagePresenter: UiMessagePresenter
) : ViewModel() {
    fun onTransitionToForeground() {
        uiMessagePresenter.showToast("Transition to Foreground")
    }
}