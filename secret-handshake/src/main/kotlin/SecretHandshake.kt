object HandshakeCalculator {
    fun calculateHandshake(number: Int): List<Signal> {
        val binary = number.toString(2)
        return binary
            .padStart(4, '0')
            .takeLast(4)
            .asIterable()
            .reversed()
            .mapIndexed { i, c -> if (c == '1') Signal.values()[i] else null }
            .filterNotNull()
            .let { if (binary.length == 5) it.reversed() else it }
    }
}
