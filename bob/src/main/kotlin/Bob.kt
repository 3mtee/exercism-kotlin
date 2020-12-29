object Bob {
    fun hey(input: String): String {

        val trimmedInput = input.trim()
        return when {
            trimmedInput.contains(Regex("[a-zA-Z]")) && trimmedInput == trimmedInput.toUpperCase() -> {
                if (trimmedInput.endsWith("?")) {
                    "Calm down, I know what I'm doing!"
                } else {
                    "Whoa, chill out!"
                }
            }
            trimmedInput.endsWith("?") -> "Sure."
            input.isBlank() -> "Fine. Be that way!"
            else -> "Whatever."
        }
    }
}
