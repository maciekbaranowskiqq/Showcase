package com.showcase.network

import com.showcase.domain.BuildConfig
import com.showcase.network.interceptor.ApiRequestHeadersInterceptor
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

@InstallIn(ApplicationComponent::class)
@Module
internal object OkHttpModule {
    @Provides
    @Reusable
    internal fun provideOkHttpClient(
        apiRequestHeadersInterceptor: ApiRequestHeadersInterceptor
    ): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(apiRequestHeadersInterceptor)
        .enableLoggingIfNeeded()
        .build()

    private fun OkHttpClient.Builder.enableLoggingIfNeeded(): OkHttpClient.Builder {
        if (BuildConfig.DEBUG) {
            addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
        }
        return this
    }
}