object ScrabbleScore {
    private val scoreMap: Map<Char, Int> = mapOf(
        listOf('a', 'e', 'i', 'o', 'u', 'l', 'n', 'r', 's', 't') to 1,
        listOf('d', 'g') to 2,
        listOf('b', 'c', 'm', 'p') to 3,
        listOf('f', 'h', 'v', 'w', 'y') to 4,
        listOf('k') to 5,
        listOf('j', 'x') to 8,
        listOf('q', 'z') to 10
    )
        .asSequence()
//        convert a sequence of lists to a sequence of maps
        .map { entry -> entry.key.associateWith { entry.value } }
//        flatten
        .flatMap { it.entries }
//        convert to map
        .associate { Pair(it.key, it.value) }


    private fun scoreLetter(c: Char): Int {
        return scoreMap.getOrDefault(c.toLowerCase(), 0)
    }

    fun scoreWord(word: String): Int {
        if (word.isBlank()) {
            return 0
        }
        return word
            .asSequence()
            .map { scoreLetter(it) }
            .reduce { acc, i -> acc + i }
    }
}
