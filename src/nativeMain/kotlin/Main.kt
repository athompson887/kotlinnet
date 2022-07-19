import org.network.NNManager
//import
fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")

    val networkManager = NNManager()
    networkManager.setupNetwork()

    GlobalScope.launch(sayHello)

    suspend fun sayHello(){

    }
 /*   NNManager mgr = new NNManager();
    mgr.SetupNetwork()
        .GetTrainingDataFromUser()
        .TrainNetworkToMinimum()
        .TestNetwork();

    Console.WriteLine("Press any key to train network for maximum");
    Console.ReadKey();

    mgr.SetupNetwork()
        .GetTrainingDataFromUser()
        .TrainNetworkToMaximum()
        .TestNetwork();

    Console.WriteLine("Press any key to exit");
    Console.ReadKey();*/



}

