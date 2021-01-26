import kotlin.math.pow

object ArmstrongNumber {

    fun check(input: Int): Boolean {
        val sInput = input.toString()
        return sInput
            .asSequence()
            .map { (it - '0').toDouble() }
            .fold(0.0) { acc, i -> acc + i.pow(sInput.length) }
            .toInt() == input
    }

}
