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
    private val uiMessagePresenter: UiMessagePresenter,
    private val navigator: BreweryScreenNavigator
) : ViewModel() {

    private val _isProgressIndicatorVisibleLiveData = MutableLiveData<Boolean>().apply { value = false }
    val isProgressIndicatorVisibleLiveData: LiveData<Boolean> = _isProgressIndicatorVisibleLiveData

    private val _breweryScreenViewStateLiveData = MutableLiveData<BreweryScreenViewState>()
    val breweryScreenViewStateLiveData: LiveData<BreweryScreenViewState> = _breweryScreenViewStateLiveData

    fun onInteraction(interaction: BreweryScreenInteractions) {
        when (interaction) {
            is BreweryScreenInteractions.ScreenEntered -> onScreenEntered()
            is BreweryScreenInteractions.ContinueButtonClicked -> onContinueButtonClicked()
        }
    }

    private fun onContinueButtonClicked() {
        navigator.navigateToNextScreen()
    }

    private fun onScreenEntered() {
        getBreweryDetails()
    }

    private fun getBreweryDetails() {
        showProgressIndicator()
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
        _breweryScreenViewStateLiveData.value = brewery.toViewState()
    }

    private fun showProgressIndicator() {
        _isProgressIndicatorVisibleLiveData.value = true
    }

    private fun hideProgressIndicator() {
        _isProgressIndicatorVisibleLiveData.value = false
    }

    data class BreweryScreenViewState(val breweryName: String)

    private fun Brewery.toViewState(): BreweryScreenViewState = BreweryScreenViewState(
        breweryName = name
    )
}

