class DiamondPrinter {

    private val alphabet = CharArray(26) { (it + 65).toChar() }


    fun printToList(c: Char): List<String> {
        require(c in 'A'..'Z')

        val vp = ('A' until c) + (c downTo 'A')
        val hp = (c downTo 'A') + ('B'..c)

        return vp.map { y -> hp.map { x -> if (x == y) y else ' ' }.joinToString("") }
    }

    /*fun printToList(letter: Char): List<String> {
        val result: MutableList<String> = mutableListOf()
        val index = alphabet.indexOf(letter)

        for (i in 0..index) {
            result.add(buildLine(index, i))
        }
        for (i in index - 1 downTo 0) {
            result.add(buildLine(index, i))
        }
        return result

    }

    private fun buildLine(letterIndex: Int, lineIndex: Int) = buildString {
        val spaceChar = " "
        for (j in lineIndex until letterIndex) {
            append(spaceChar)
        }
        val letter = alphabet[lineIndex]
        append(letter)

        if (lineIndex != 0 && lineIndex != (letterIndex + 1) * 2 - 1) {
            for (k in 0..(lineIndex - 1) * 2) {
                append(spaceChar)
            }
            append(letter)
        }
        for (j in lineIndex until letterIndex) {
            append(spaceChar)
        }
    }*/
}

fun main() {
    DiamondPrinter().printToList('B').forEach { println(it) }
}

