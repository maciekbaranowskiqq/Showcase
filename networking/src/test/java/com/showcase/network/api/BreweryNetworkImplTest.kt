package com.showcase.network.api

import com.showcase.domain.Brewery
import com.showcase.network.api.model.BreweryApiModel
import com.showcase.network.common.ApiCallResult
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class BreweryNetworkImplTest {
    private lateinit var subject: BreweryNetworkImpl

    @RelaxedMockK
    private lateinit var mockedApiService: BreweryApiService

    @Before
    fun setUp() {
        MockKAnnotations.init(this)

        subject = BreweryNetworkImpl(
            apiService = mockedApiService
        )
    }

    @Test
    fun `gets Brewery Details`() = runBlockingTest {
        val sampleBrewery = BreweryApiModel(
            id = 1,
            name = "Brewery Name"
        )

        val domainBrewery = Brewery(
            id = sampleBrewery.id,
            name = sampleBrewery.name
        )

        coEvery { mockedApiService.getRandomBrewery() } returns sampleBrewery

        assertEquals(ApiCallResult.Success(domainBrewery), subject.getRandomBrewery())
    }
}