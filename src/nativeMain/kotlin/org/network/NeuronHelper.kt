package org.network

import kotlin.math.exp


fun sigmoid(x:Double):Double
{
    return 1.0/(1 + exp(-x))
}
