object Flattener {
    fun flatten(source: Collection<Any?>): List<Any> {
        return source
            .flatMap {
                if (it is Collection<Any?>) {
                    flatten(it)
                } else {
                    listOf(it)
                }
            }
            .filterNotNull()
    }
}
