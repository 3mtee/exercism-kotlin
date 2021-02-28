class RotationalCipher(shift: Int) {
    companion object {
        @JvmStatic
        private val ALPHABET_SIZE = ('a'..'z').count()
    }

    private val shift = shift % ALPHABET_SIZE

    fun encode(text: String): String = text
        .asSequence()
        .map { rotateChar(it) }
        .joinToString("")

    private fun rotateChar(char: Char): Char {
        val shiftedChar = char + shift

        return when {
            (char.isUpperCase() && shiftedChar > 'Z') ||
                    (char.isLowerCase() && shiftedChar > 'z') -> shiftedChar - ALPHABET_SIZE
            char.isLetter() -> shiftedChar
            else -> char
        }
    }
}
