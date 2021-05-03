object Atbash {
    private val alphabet = 'a'..'z'
    private val reversedAlphabet = alphabet.reversed()
    private val encodeMap = alphabet.zip(reversedAlphabet).toMap()
    private val decodeMap = reversedAlphabet.zip(alphabet).toMap()
    fun encode(s: String) = s
        .toLowerCase()
        .asSequence()
        .filter { it.isLetterOrDigit() }
        .map { encodeMap.getOrDefault(it, it) }
        .joinToString("")
        .windowed(5, step = 5, partialWindows = true)
        .joinToString(" ")

    fun decode(s: String) = s
        .toLowerCase()
        .filter { it.isLetterOrDigit() }
        .map { decodeMap.getOrDefault(it, it) }
        .joinToString("")
}
