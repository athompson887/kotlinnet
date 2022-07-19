package org.network.models

import kotlin.math.exp


fun output(x: Double): Double {

    return if (x < -45.0) 0.0 else if (x > 45) 1.0 else 1.0 / (1 + exp(-x))
}

fun derivative(x: Double): Double {
    return x * (1 - x);
}
