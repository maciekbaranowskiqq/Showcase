package com.showcase.network.api.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BreweryApiModel(
    @Json(name = "id")
    val id: Long,
    @Json(name = "name")
    val name: String
)