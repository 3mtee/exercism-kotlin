class RotationalCipher(shift: Int) {
    companion object{
        @JvmStatic
        private val ALPHABET_SIZE = ('a'..'z').count()
    }

    private val shift = shift % ALPHABET_SIZE

    fun encode(text: String): String {
        return text
            .asSequence()
            .map { rotateChar(it) }
            .joinToString("")
    }

    private fun rotateChar(char: Char): Char {
        val lowerChar = char.toLowerCase()
        val shiftedChar = lowerChar + shift
        val rotationResult = when {
            shiftedChar > 'z' -> shiftedChar - ALPHABET_SIZE
            char.isLetter() -> shiftedChar
            else -> lowerChar
        }
        return if (char.isUpperCase()) {
            rotationResult.toUpperCase()
        } else {
            rotationResult
        }
    }
}
