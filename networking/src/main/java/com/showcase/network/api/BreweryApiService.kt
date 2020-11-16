package com.showcase.network.api

import com.showcase.network.api.model.BreweryApiModel
import retrofit2.http.GET

internal interface BreweryApiService {
    @GET("breweries/5494")
    suspend fun getRandomBrewery(): BreweryApiModel
}