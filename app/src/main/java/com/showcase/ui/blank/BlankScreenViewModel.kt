package com.showcase.ui.blank

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BlankScreenViewModel @ViewModelInject constructor(

) : ViewModel() {

    private val _isProgressIndicatorVisibleLiveData = MutableLiveData<Boolean>().apply { value = false }
    val isProgressIndicatorVisibleLiveData: LiveData<Boolean> = _isProgressIndicatorVisibleLiveData

    private val _onDataTextChangedLiveData = MutableLiveData<String>().apply { value = "" }
    val onDataTextChangedLiveData: LiveData<String> = _onDataTextChangedLiveData

    fun onInteraction(interaction: BlankScreenInteractions) {
        when (interaction) {
            is BlankScreenInteractions.ScreenEntered -> onScreenEntered()
        }
    }

    private fun onScreenEntered() {
        showProgressIndicator()
        showResultMessage("Show example message")
        hideProgressIndicator()
    }

    private fun showResultMessage(resultMessage: String) {
        _onDataTextChangedLiveData.value = resultMessage
    }

    private fun showProgressIndicator() {
        _isProgressIndicatorVisibleLiveData.value = true
    }

    private fun hideProgressIndicator() {
        _isProgressIndicatorVisibleLiveData.value = false
    }
}

