import kotlin.math.pow

object ArmstrongNumber {

    fun check(input: Int): Boolean {
        val sInput = input.toString()
        return sInput
            .asSequence()
            .map { (it - '0').toDouble() }
            .sumOf { it.pow(sInput.length).toInt() } == input
    }

}
