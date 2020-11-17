package com.showcase.ui.main

import com.showcase.common.UiMessagePresenter
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.Before
import org.junit.Test

class MainActivityViewModelTest {
    private lateinit var subject: MainActivityViewModel

    @RelaxedMockK
    private lateinit var mockedUiMessagePresenter: UiMessagePresenter

    @Before
    fun setUp() {
        MockKAnnotations.init(this)

        subject = MainActivityViewModel(
            uiMessagePresenter = mockedUiMessagePresenter
        )
    }

    @Test
    fun `shows toast when apps going to foreground`() {
        subject.onTransitionToForeground()

        verify { mockedUiMessagePresenter.showToast(any()) }
    }

}