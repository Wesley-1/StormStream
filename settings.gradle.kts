rootProject.name = "StormStream"

setupStreamModule(
    "storm-stream",
    listOf(
        Pair("game", listOf("terminal-game")),
        Pair("services", listOf("commons", "wallet-service", "notification-service", "chat-service")),
    ));


fun setupStreamModule(base: String, setup: List<Pair<String, List<String>>>) =
    setup.forEach { pair
        -> pair.second.forEach { name
        -> setupSubproject(name, file("$base/${pair.first}/$name"))
    }
}


fun setupSubproject(name: String, projectDirectory: File) = setupSubproject(name) {
    projectDir = projectDirectory
}

inline fun setupSubproject(name: String, block: ProjectDescriptor.() -> Unit) {
    include(name)
    project(":$name").apply(block)
}