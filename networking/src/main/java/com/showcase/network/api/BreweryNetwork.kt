package com.showcase.network.api

import com.showcase.domain.Brewery
import com.showcase.network.api.model.BreweryApiModel
import com.showcase.network.common.ApiCallResult
import com.showcase.network.common.executeApiCallSafely
import javax.inject.Inject

interface BreweryNetwork {
    suspend fun getRandomBrewery(): ApiCallResult<Brewery>
}

internal class BreweryNetworkImpl @Inject constructor(
    private val apiService: BreweryApiService
) : BreweryNetwork {

    override suspend fun getRandomBrewery(): ApiCallResult<Brewery> = executeApiCallSafely {
        apiService.getRandomBrewery().toDomainBreweryModel()
    }

    private fun BreweryApiModel.toDomainBreweryModel(): Brewery = Brewery(
        id = id,
        name = name
    )
}