fun hello(name: String = ""): String {
    return "Hello, ${if (name.isBlank()) "World" else name}!"
}
