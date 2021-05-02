class ChangeCalculator(coins: List<Int>) {
    private val coins = coins.reversed()

    fun computeMostEfficientChange(grandTotal: Int): List<Int> {
        require(grandTotal >= 0) { "Negative totals are not allowed." }
        require((grandTotal == 0) || (grandTotal >= this.coins.minOrNull()!!)) { "The total $grandTotal cannot be represented in the given currency." }

        return computeChange(grandTotal).sorted()
    }

    private fun computeChange(grandTotal: Int): List<Int> {
        val changes = mutableListOf<List<Int>>()
        0.rangeTo(grandTotal)
            .map { change -> changes.add(computeMinChange(change, changes)) }

        return changes[grandTotal].takeIf { it.sum() == grandTotal }
            ?: throw IllegalArgumentException("The total $grandTotal cannot be represented in the given currency.")
    }

    private fun computeMinChange(changeAmount: Int, lowerChanges: List<List<Int>>) =
        this.coins
            // filter out coins which are greater than the change amount
            .filter { it <= changeAmount }
            // group lower change amounts using bigger coins
            .map { listOf(it) + lowerChanges[changeAmount - it] }
            // filter out coin combos which aren't equal to the change amount
            .filter { it.sum() == changeAmount }
            // get the lowest number of coins for the change amount
            .minByOrNull { it.size } ?: emptyList()
}
