object ETL {
    fun transform(source: Map<Int, Collection<Char>>) = source
        .flatMap { transform(it) }
        .toMap()

    private fun transform(sourceEntry: Map.Entry<Int, Collection<Char>>) =
        sourceEntry.value.map { Pair(it.lowercaseChar(), sourceEntry.key) }
}
