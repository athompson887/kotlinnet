package org.network
import org.network.models.NNDataSet
import org.network.models.Network

class NNManager {

    val total: Int // property type is optional since it can be inferred from the getter's return type
        get() = this.numInputParameters * this.numOutputParameters
    var numInputParameters:Int=0
    var numHiddenLayers:Int=0
    var hiddenNeurons:List<Int> = listOf(3,1)
    var numOutputParameters:Int=0
    var network:Network? = null
    var dataSets:MutableList<NNDataSet> = mutableListOf()


    fun setupNetwork():NNManager
    {
        numInputParameters = 2
        hiddenNeurons = listOf(3,1)
        numHiddenLayers = 1
        numOutputParameters = 1
        network = Network(numInputParameters, hiddenNeurons, numOutputParameters)
        return this
    }

    companion object{


    }
}