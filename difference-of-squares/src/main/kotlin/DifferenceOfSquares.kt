import kotlin.math.pow

class Squares(number: Int) {

    private val range = IntRange(0, number).asSequence()

    fun sumOfSquares(): Int {
        return range
            .map { it.toDouble().pow(2) }
            .sum()
            .toInt()
    }

    fun squareOfSum(): Int {
        return range
            .sum()
            .toDouble()
            .pow(2)
            .toInt()
    }

    fun difference(): Int {
        return squareOfSum() - sumOfSquares()
    }
}
