object ScrabbleScore {
    private val scoreMap: Map<Char, Int> = mapOf(
        "a,e,i,o,u,l,n,r,s,t" to 1,
        "d,g" to 2,
        "b,c,m,p" to 3,
        "f,h,v,w,y" to 4,
        "k" to 5,
        "j,x" to 8,
        "q,z" to 10
    )
        .asSequence()
//        convert a sequence of lists to a sequence of maps
        .map { entry -> entry.key.split(',').associate { Pair(it[0], entry.value) } }
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
