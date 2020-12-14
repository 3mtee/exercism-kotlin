object Pangram {

    fun isPangram(input: String): Boolean {
        val lowerInput = input.toLowerCase()
        CharRange('a', 'z').forEach { if (!lowerInput.contains(it)) return false }
        return true
    }
}
