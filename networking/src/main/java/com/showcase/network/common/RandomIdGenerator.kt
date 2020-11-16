package com.showcase.network.common

import java.util.*
import javax.inject.Inject

internal class RandomIdGenerator @Inject constructor() {
    fun generateNewId() = UUID.randomUUID().toString()
}