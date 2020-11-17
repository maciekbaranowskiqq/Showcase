package com.showcase.network.interceptor

import com.showcase.network.common.RandomIdGenerator
import io.mockk.Called
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import okhttp3.Interceptor
import okhttp3.Request
import org.junit.Before
import org.junit.Test

class ApiRequestHeadersInterceptorTest {
    private lateinit var subject: ApiRequestHeadersInterceptor

    @RelaxedMockK private lateinit var mockedRandomIdGenerator: RandomIdGenerator
    @RelaxedMockK private lateinit var mockedChain: Interceptor.Chain
    @RelaxedMockK private lateinit var mockedRequest: Request

    @Before
    fun setUp() {
        MockKAnnotations.init(this)

        subject = ApiRequestHeadersInterceptor(
            randomIdGenerator = mockedRandomIdGenerator
        )
    }

    @Test
    fun `sets API-related headers`() {
        every { mockedChain.request() } returns mockedRequest
        every { mockedRandomIdGenerator.generateNewId() } returns "random id"

        subject.intercept(mockedChain)

        verify {
            mockedRequest.newBuilder()
                .header("x-request-id", "random id")
                .header("x-platform", "Android")
                .build()
        }
        verify { mockedChain.proceed(mockedRequest) wasNot Called }
    }
}