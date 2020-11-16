package com.showcase.network.common

import io.mockk.every
import io.mockk.mockkStatic
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.util.*

class RandomIdGeneratorTest {
    private lateinit var subject: RandomIdGenerator

    @Before
    fun setUp() {
        subject = RandomIdGenerator()
    }

    @Test
    fun `uses randomUUID to generate random ids`() {
        mockkStatic(UUID::class)
        every { UUID.randomUUID().toString() } returns "randomID"

        assertEquals("randomID", subject.generateNewId())
    }
}
