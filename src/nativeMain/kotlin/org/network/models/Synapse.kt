package org.network.models

class Synapse(var inputNeuron: Neuron, var outputNeuron: Neuron)
{
    var iD:String = "TODO"
    var weightDelta: Double = 0.0
    var weight: Double = 0.0

    init{
        iD = ""
        weight = Network.getRandom()
    }
}
