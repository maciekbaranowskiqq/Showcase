package com.showcase.network

import com.showcase.network.BuildConfig.API_URL
import com.showcase.network.api.BreweryApiService
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@InstallIn(ApplicationComponent::class)
@Module
internal object RetrofitModule {
    @Provides
    @Reusable
    internal fun provideMoshi(): Moshi = Moshi.Builder().build()

    @Provides
    @Reusable
    internal fun provideMoshiConverterFactory(moshi: Moshi): MoshiConverterFactory =
        MoshiConverterFactory.create(moshi)

    @Provides
    @Reusable
    internal fun provideRetrofit(
        okHttpClient: OkHttpClient,
        moshiConverterFactory: MoshiConverterFactory
    ): Retrofit = Retrofit.Builder()
        .baseUrl(API_URL)
        .client(okHttpClient)
        .addConverterFactory(moshiConverterFactory)
        .build()

    @Provides
    @Reusable
    internal fun provideBreweryApiService(retrofit: Retrofit): BreweryApiService =
        retrofit.create(BreweryApiService::class.java)
}