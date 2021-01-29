import kotlin.math.pow

object HandshakeCalculator {
    fun calculateHandshake(number: Int): List<Signal> = Signal
        .values()
        .filter { isChosen(it, number) }
        .let { if (number.toString(2).length == 5) it.reversed() else it }

    private fun isChosen(signal: Signal, number: Int) = number and 2.0.pow(signal.ordinal).toInt() != 0
}
