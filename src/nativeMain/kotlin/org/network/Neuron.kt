package org.network

class Neuron() {
    var iD:String = "TODO"
    var inputSynapses: MutableList<Synapse>
    var outputSynapses: MutableList<Synapse>
    var bias: Double = 0.0
    var biasDelta: Double = 0.0
    var gradient: Double = 0.0
    var isMirror: Boolean = false
    var isCanolical: Boolean = false
    var value:Double = 0.0

    init{
        bias = Network.getRandom()
        iD = "TODO"
        inputSynapses = mutableListOf()
        outputSynapses = mutableListOf()
    }

    constructor (inputNeurons: List<Neuron>?) : this() {
        if (inputNeurons != null) {
            for (inputNeuron in inputNeurons) {
                val synapse = Synapse(inputNeuron, this)
                inputNeuron.outputSynapses.add(synapse)
                inputSynapses.add(synapse)
            }
        }
    }

    fun calculateValue():Double?
    {
        return inputSynapses.sumOf {(it.weight * it.inputNeuron.value)+bias  }
    }

    fun calculateError(target:Double):Double
    {
        return target - value
    }
    fun calculateGradient(target: Double? = null ):Double {
        return if (target == null) {
            gradient +  outputSynapses.sumOf {(it.outputNeuron.gradient * it.weight) }
        } else {
            gradient + calculateError(target) * derivative(value)
        }
    }

    fun updateWeights(learnRate: Double,momentum: Double) {
        var prevDelta = biasDelta
        biasDelta = learnRate * gradient
        bias += biasDelta + momentum * prevDelta

        for(synapse in inputSynapses)
        {
            prevDelta = synapse.weightDelta
            synapse.weightDelta = learnRate * gradient * synapse.inputNeuron.value
            synapse.weight += synapse.weightDelta + momentum * prevDelta
        }
    }
}