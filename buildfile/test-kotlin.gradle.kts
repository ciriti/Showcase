tasks.register("printDependencies") {
    group = "learning"
    configurations.forEach { config ->
        println("=============================================")
        println("config: [${config.name}]")
        config.dependencies.forEach { dep ->
            println("   dep: [${dep}}")
        }
    }
}