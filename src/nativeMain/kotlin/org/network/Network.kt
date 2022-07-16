package org.network

class NeuralNetwork(var numInputs: Int, var numOutputs:Int, var numMiddle:Int, var numLayers:Int) {
    private val nodeCount: Int = numInputs + numOutputs + (numLayers * numMiddle)
    fun printDetails() {
        print(
            """Network created with the following configeration
                   inputs : $numInputs 
                   outputs: $numOutputs 
                   middle: $numMiddle
                   layers: $numLayers
                   nodeCount: $nodeCount
                   """
        )
    }
}
