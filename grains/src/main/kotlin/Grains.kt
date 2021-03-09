import java.math.BigInteger

object Board {

    fun getGrainCountForSquare(number: Int): BigInteger = BigInteger.TWO
        .apply { require(number in 1..64) { throw IllegalArgumentException("Incorrect input") } }
        .pow(number - 1)

    fun getTotalGrainCount(): BigInteger =
        (0 until 64)
            .map { BigInteger.TWO.pow(it) }
            .fold(BigInteger.ZERO) { acc, count -> acc.plus(count) }
}
