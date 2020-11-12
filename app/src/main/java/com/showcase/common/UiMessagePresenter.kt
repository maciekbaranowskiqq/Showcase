package com.showcase.common

import android.widget.Toast
import javax.inject.Inject

class UiMessagePresenter @Inject constructor(
    private val mainActivityProvider: MainActivityProvider
) {
    private val context get() = mainActivityProvider.getMainActivity()

    fun showToast(message: String) {
        context?.let { Toast.makeText(it, message, Toast.LENGTH_SHORT).show() }
    }
}
