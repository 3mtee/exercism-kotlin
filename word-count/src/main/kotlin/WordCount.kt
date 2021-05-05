object WordCount {

    fun phrase(phrase: String): Map<String, Int> = phrase
        .split(Regex("[\\s,.]"))
        .filter { it.isNotEmpty() }
        .map { clearWord(it) }
        .groupingBy { it }
        .eachCount()

    private fun clearWord(word: String) = word
        .trim('\'') // remove any quotations around words
        .replace(Regex("[^\\w\\d']"), "") // leave only alphanums + quotes
        .lowercase()
}
