package org.network
import kotlin.test.Test
import kotlin.test.assertEquals

class NetworkTest {

    @Test
    fun testSigmoid()
    {
        val result = sigmoid(5.0)
        assertEquals(0.9933071490757153,result)
    }
}