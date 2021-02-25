class RotationalCipher(shift: Int) {
    private val shift = shift % 26

    fun encode(text: String): String {
        return text
            .asSequence()
            .map {
                val lowerChar = it.toLowerCase()
                val c = lowerChar + shift > 'z'
                val result: Char = if (c) {
                    lowerChar - 26 + shift
                } else if (!it.isLetter()) {
                    lowerChar
                } else {
                    it + shift
                }
                if (!it.isLowerCase()) {
                    return@map result.toUpperCase()
                } else {
                    return@map result
                }
            }
            .joinToString("")
    }
}
