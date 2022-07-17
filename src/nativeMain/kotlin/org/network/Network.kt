package org.network

class Network() {
    var learningRate:Double = 0.0
    var momentum:Double = 0.0
    var inputLayer: MutableList<Neuron>
    var outputLayer: MutableList<Neuron>
    var hiddenLayers: MutableList<MutableList<Neuron>>
    var mirrorLayer: MutableList<Neuron>
    var canonicalLayer: MutableList<Neuron>

    constructor (inputSize:Int, hiddenSizes:List<Int>, outputSize:Int, learnRate:Double? = null,  momentum:Double? = null): this()
    {
        this.learningRate = learnRate?:0.434
        this.momentum = momentum?:0.912
        this.inputLayer =  mutableListOf()
        this.outputLayer =  mutableListOf()
        this.mirrorLayer =  mutableListOf()
        this.canonicalLayer = mutableListOf()
        this.hiddenLayers = mutableListOf()

        repeat(inputSize) {
            inputLayer.add(Neuron());
        }

        val firstHiddenLayer: MutableList<Neuron> = mutableListOf()

        repeat(hiddenSizes.size) {
            firstHiddenLayer.add(Neuron(inputLayer))
        }

        hiddenLayers.add(firstHiddenLayer)

        repeat(hiddenSizes.size) { outerIt ->
            val hiddenLayer:MutableList<Neuron> = mutableListOf()
            repeat(hiddenSizes[outerIt]) {
                val neuronToAdd = hiddenLayer[it-1]
                hiddenLayer.add(neuronToAdd)
            }
            hiddenLayers.add(hiddenLayer)
        }
        repeat(outputSize) {
            outputLayer.add(Neuron());
        }
    }

    init {
        learningRate = 0.0
        momentum = 0.0
        inputLayer =  mutableListOf()
        outputLayer =  mutableListOf()
        mirrorLayer =  mutableListOf()
        canonicalLayer = mutableListOf()
        hiddenLayers = mutableListOf()
    }
    companion object {
        fun getRandom(): Double {
            return 0.0 //todo
        }
    }
}
