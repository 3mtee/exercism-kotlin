object ScrabbleScore {

    private fun scoreLetter(c: Char): Int = when (c.lowercaseChar()) {
        in "aeioulnrst" -> 1
        in "dg" -> 2
        in "bcmp" -> 3
        in "fhvwy" -> 4
        in "k" -> 5
        in "jx" -> 8
        in "qz" -> 10
        else -> 0
    }

    fun scoreWord(word: String) = word.sumOf { scoreLetter(it) }
}
