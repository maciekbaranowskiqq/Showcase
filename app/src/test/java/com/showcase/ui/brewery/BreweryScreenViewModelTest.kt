package com.showcase.ui.brewery

import com.showcase.common.UiMessagePresenter
import com.showcase.domain.Brewery
import com.showcase.network.api.BreweryNetwork
import com.showcase.network.common.ApiCallResult
import com.showcase.util.InstantTaskExecutionTest
import io.mockk.impl.annotations.RelaxedMockK
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import com.showcase.ui.brewery.BreweryScreenInteractions.*
import io.mockk.*

class BreweryScreenViewModelTest : InstantTaskExecutionTest() {
    private lateinit var subject: BreweryScreenViewModel

    @RelaxedMockK private lateinit var mockedBreweryNetwork: BreweryNetwork
    @RelaxedMockK private lateinit var mockedUiMessagePresenter: UiMessagePresenter
    @RelaxedMockK private lateinit var mockedBreweryScreenNavigator: BreweryScreenNavigator

    @Before
    override fun setUp() {
        super.setUp()
        MockKAnnotations.init(this)

        subject = BreweryScreenViewModel(
            breweryNetwork = mockedBreweryNetwork,
            uiMessagePresenter = mockedUiMessagePresenter,
            navigator = mockedBreweryScreenNavigator
        )
    }

    @Test
    fun `shows progress indicator while requesting brewery details`() {
        coEvery { mockedBreweryNetwork.getRandomBrewery() } returns ApiCallResult.Failure(Throwable())

        testCoroutineDispatcher.pauseDispatcher()
        subject.onInteraction(ScreenEntered)
        assertEquals(true, subject.isProgressIndicatorVisibleLiveData.value)

        testCoroutineDispatcher.resumeDispatcher()
        assertEquals(false, subject.isProgressIndicatorVisibleLiveData.value)
    }

    @Test
    fun `load Brewery when screen entered `() {
        subject.onInteraction(ScreenEntered)

        coVerify { mockedBreweryNetwork.getRandomBrewery() }
    }

    @Test
    fun `shows toast message when call for Random Brewery is cancelled`() {
        coEvery { mockedBreweryNetwork.getRandomBrewery() } returns ApiCallResult.Cancelled(
            Throwable("Sample Error")
        )

        subject.onInteraction(ScreenEntered)

        verify { mockedUiMessagePresenter.showToast("Brewery fetch cancelled: Sample Error") }
    }

    @Test
    fun `shows toast message when call for Random Brewery fails`() {
        coEvery { mockedBreweryNetwork.getRandomBrewery() } returns ApiCallResult.Failure(
            Throwable(
                "Sample Error"
            )
        )

        subject.onInteraction(ScreenEntered)

        verify { mockedUiMessagePresenter.showToast("Brewery fetch failure: Sample Error") }
    }

    @Test
    fun `renders brewery view state when call for Random Brewery is successful`() {
        val sampleBrewery = Brewery(
            id = 1,
            name = "Brewery Name"
        )

        val expectedMoreScreenViewState = BreweryScreenViewModel.BreweryScreenViewState(
            breweryName = sampleBrewery.name
        )

        coEvery { mockedBreweryNetwork.getRandomBrewery() } returns ApiCallResult.Success(
            sampleBrewery
        )

        subject.onInteraction(ScreenEntered)

        assertEquals(expectedMoreScreenViewState, subject.breweryScreenViewStateLiveData.value)
    }

    @Test
    fun `navigates to next screen when continue button is clicked`() {

        subject.onInteraction(ContinueButtonClicked)

        verify { mockedBreweryScreenNavigator.navigateToNextScreen() }
    }
}