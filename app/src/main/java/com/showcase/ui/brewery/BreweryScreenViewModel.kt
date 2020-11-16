package com.showcase.ui.brewery

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.showcase.common.UiMessagePresenter
import com.showcase.domain.Brewery
import com.showcase.network.api.BreweryNetwork
import com.showcase.network.common.ApiCallResult
import kotlinx.coroutines.launch

class BreweryScreenViewModel @ViewModelInject constructor(
    private val breweryNetwork: BreweryNetwork,
    private val uiMessagePresenter: UiMessagePresenter
) : ViewModel() {

    private val _isProgressIndicatorVisibleLiveData =
        MutableLiveData<Boolean>().apply { value = false }
    val isProgressIndicatorVisibleLiveData: LiveData<Boolean> = _isProgressIndicatorVisibleLiveData

    private val _onDataTextChangedLiveData = MutableLiveData<String>().apply { value = "" }
    val onDataTextChangedLiveData: LiveData<String> = _onDataTextChangedLiveData

    fun onInteraction(interaction: BreweryScreenInteractions) {
        when (interaction) {
            is BreweryScreenInteractions.ScreenEntered -> onScreenEntered()
        }
    }

    private fun onScreenEntered() {
        showProgressIndicator()
        getBreweryCall()
    }

    private fun getBreweryCall() {
        viewModelScope.launch {
            when (val result = breweryNetwork.getRandomBrewery()) {
                is ApiCallResult.Success -> onBreweryFetched(result.body)
                is ApiCallResult.Failure -> uiMessagePresenter.showToast("Brewery fetch failure: ${result.cause.message}")
                is ApiCallResult.Cancelled -> uiMessagePresenter.showToast("Brewery fetch cancelled: ${result.cause.message}")
            }
            hideProgressIndicator()
        }
    }

    private fun onBreweryFetched(brewery: Brewery) {
        showResultMessage(brewery.name)
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

