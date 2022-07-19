package org.network.models

import kotlin.math.abs
import kotlin.random.Random

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

    fun train(dataSets:List<NNDataSet>, numEpochs:Int)
    {
        repeat(numEpochs) {
            for(dataSet in dataSets)
            {
                forwardPropagate(dataSet.values)
                backPropagate(dataSet.targets)
            }
        }
    }

    fun train(dataSets:List<NNDataSet>, minimumError:Double)
    {
        var error = 1.0;
        var numEpochs = 0;

        while (error > minimumError && numEpochs < Int.MAX_VALUE)
        {
            val errors:MutableList<Double> = mutableListOf()
            for(dataSet in dataSets)
            {
                forwardPropagate(dataSet.values)
                backPropagate(dataSet.targets)
                errors.add(calculateError(dataSet.targets))
            }
            error = errors.average()
            numEpochs++
        }
    }

    fun compute(inputs:List<Double>):List<Double>
    {
        forwardPropagate(inputs)
        val res:MutableList<Double> = mutableListOf()
        outputLayer.forEach {
            res.add(it.value)
        }
        return res
    }

    fun calculateError(targets:List<Double>):Double
    {
        var i = 0;
        return outputLayer.sumOf{( abs(it.calculateError(targets[i++])) )}
    }

    fun forwardPropagate(inputs: List<Double>) {
        var i = 0;
        inputLayer.forEach { it.value = inputs[i++] }
        hiddenLayers.forEach { a -> a.forEach { b -> b.calculateValue() }}
        outputLayer.forEach { a -> a.calculateValue()}
    }
    fun backPropagate(targets: List<Double>) {
        var i = 0;
        outputLayer.forEach { it.calculateGradient(targets[i++]) }
        hiddenLayers.reverse()
        hiddenLayers.forEach{ it.forEach{ b -> b.calculateGradient() }}
        hiddenLayers.forEach{ it -> it.forEach{ b -> b.updateWeights(learningRate, momentum)}}
        hiddenLayers.reverse()
        outputLayer.forEach{it.updateWeights(learningRate, momentum)}
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
        fun getRandom():Double {
            return 2 * Random.nextDouble() - 1;
        }
    }

    enum class TrainingType
    {
        EPOCH,
        MINIMUM_ERROR
    }
}
