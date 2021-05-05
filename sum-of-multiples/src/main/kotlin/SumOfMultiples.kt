object SumOfMultiples {
    fun sum(multiples: Set<Int>, limit: Int): Int =
        multiples.filter { it != 0 }.flatMap { 0 until limit step it }.toSet().sum()
}
