object Isogram {

    fun isIsogram(input: String): Boolean =
        input
            .lowercase()
            .filter { it.isLetter() }
            .let { it.toSet().size == it.length }
}
