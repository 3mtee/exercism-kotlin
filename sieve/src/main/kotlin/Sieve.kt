object Sieve {

    fun primesUpTo(upperBound: Int): List<Int> {
        val composites = mutableSetOf<Int>()
        val results = mutableListOf<Int>()
        (2..upperBound)
            .forEach { i ->
                if (i !in composites) {
                    results.add(i)
                }
                (i..upperBound)
                    .forEach { j -> if (j % i ==0) composites.add(j) }
            }
        return results
    }
}
