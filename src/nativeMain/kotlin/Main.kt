import org.network.NeuralNetwork

fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")

    val myNetwork = NeuralNetwork(numInputs = 3, numOutputs = 4, numMiddle = 5, numLayers = 2)
    myNetwork.printDetails()
}

