object CollatzCalculator {
    fun computeStepCount(start: Int, step: Int = 0): Int = when {
        start < 1 -> throw IllegalArgumentException("Incorrect input")
        start == 1 -> step
        start % 2 == 0 -> computeStepCount(start / 2, step + 1)
        else -> computeStepCount(start * 3 + 1, step + 1)
    }
}
