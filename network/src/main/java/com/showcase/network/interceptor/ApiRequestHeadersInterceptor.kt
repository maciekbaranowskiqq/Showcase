package com.showcase.network.interceptor

import com.showcase.network.common.RandomIdGenerator
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject

private const val DEVICE_PLATFORM = "Android"
internal const val HEADER_REQUEST_ID = "x-request-id"
internal const val HEADER_PLATFORM = "x-platform"

internal class ApiRequestHeadersInterceptor @Inject constructor(
    private val randomIdGenerator: RandomIdGenerator
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        return chain.proceed(request.withRequestIdHeader())
    }

    private fun Request.withRequestIdHeader(): Request {
        return newBuilder()
            .header(HEADER_REQUEST_ID, randomIdGenerator.generateNewId())
            .header(HEADER_PLATFORM, DEVICE_PLATFORM)
            .build()
    }
}