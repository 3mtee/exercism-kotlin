object Pangram {

    fun isPangram(input: String): Boolean {
        val lowerInput = input.lowercase()
        CharRange('a', 'z').forEach { if (!lowerInput.contains(it)) return false }
        return true
    }
}
