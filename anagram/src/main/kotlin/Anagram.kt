class Anagram(private val source: String) {
    private val sourcePieces: List<Char> = source.toLowerCase().toList().sorted()

    fun match(anagrams: Collection<String>): Set<String> {
        return anagrams
            .filter { !source.equals(it, true) && it.toLowerCase().toList().sorted() == sourcePieces }
            .toSet()
    }
}
