import kotlin.math.pow

object HandshakeCalculator {
    fun calculateHandshake(number: Int): List<Signal> {
        val signals = Signal.values().reversed()
        var i = 0
        var n = number
        val result = mutableListOf<Signal>()
        var revert = true
        while (n > 0) {
            val signal = signals[i]
            val num = 2.0.pow(signal.ordinal).toInt()
            if (num > n) {
                i++
            } else {
                n -= num
                if (signal == Signal.REVERT) {
                    revert = !revert
                } else
                    result.add(signal)
            }
        }

//        val binary = number.toString(2)

        return if (revert) result.reversed() else result
    }
}

fun main() {
    print(HandshakeCalculator.calculateHandshake(19))
}
