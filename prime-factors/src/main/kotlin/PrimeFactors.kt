object PrimeFactorCalculator {

    fun primeFactors(int: Int): List<Int> = primeFactors(int.toLong()).map { it.toInt() }

    fun primeFactors(long: Long): List<Long> {
        val results = mutableListOf<Long>()
        var num = long
        var divider = 2L
        while (num > 1) {
            if (num % divider == 0L) {
                num /= divider
                results.add(divider)
            } else {
                divider++
            }
        }
        return results
    }
}
