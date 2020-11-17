package com.showcase.ui.brewery

import com.showcase.common.UiMessagePresenter
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.Before
import org.junit.Test

class BreweryScreenNavigatorTest {
    private lateinit var subject: BreweryScreenNavigator

    @RelaxedMockK private lateinit var mockedUiMessagePresenter: UiMessagePresenter

    @Before
    fun setUp() {
        MockKAnnotations.init(this)

        subject = BreweryScreenNavigator(
            uiMessagePresenter = mockedUiMessagePresenter
        )
    }

    @Test
    fun `show Toast with information about what should happen next`() {
        subject.navigateToNextScreen()

        verify { mockedUiMessagePresenter.showToast("Should take user to the next screen.") }
    }
}
