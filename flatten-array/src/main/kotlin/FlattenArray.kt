object Flattener {
    fun flatten(source: Collection<Any?>): List<Any> {
        val results = mutableListOf<Any>()
        source.forEach {
            if (it is Collection<Any?>) {
                results.addAll(flatten(it))
            } else if (it != null) {
                results.add(it)
            }
        }
        return results
    }
}
