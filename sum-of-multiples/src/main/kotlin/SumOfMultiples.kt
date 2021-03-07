object SumOfMultiples {

    fun sum(factors: Set<Int>, limit: Int) = if (factors.isNotEmpty()) {
        (factors.minOrNull()!! until limit)
            .filter { factors.any { it != 0 && it % it == 0 } }
            .sum()
    } else {
        0
    }
}
