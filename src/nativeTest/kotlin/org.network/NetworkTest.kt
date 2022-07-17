package org.network
import kotlin.test.Test
import kotlin.test.assertEquals

class NetworkTest {

    @Test
    fun testSigmoidOutput()
    {
        val result = output(5.0)
        assertEquals(0.9933071490757153,result)
    }

    @Test
    fun testSigmoidOutputLessThanMinus45()
    {
        val result = output(-46.0)
        assertEquals(0.0,result)
    }

    @Test
    fun testSigmoidOutputMoreThan45()
    {
        val result = output(46.0)
        assertEquals(1.0,result)
    }

    @Test
    fun testSigmoidDerivative()
    {
        val result = derivative(5.0)
        assertEquals(-20.0,result)
    }
}