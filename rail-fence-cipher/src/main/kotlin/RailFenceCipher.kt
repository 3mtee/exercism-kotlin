class RailFenceCipher(private val railFence: Int) {

    fun getEncryptedData(input: String): String = getRailFenceSequence()
        .take(input.length)
        .zipRailFence(input.asSequence())
        .joinToString("")

    fun getDecryptedData(input: String): String = getRailFenceSequence()
        .take(input.length)
        .zipRailFence(input.indices.asSequence())
        .zipRailFence(input.asSequence())
        .joinToString("")

    private fun getRailFenceSequence() = generateSequence(0) { it + 1 }
        .map {
            (0 until railFence - 1)
                .plus(railFence - 1 downTo 1)[it % (2 * (railFence - 1))]
        }

    private fun <T : Comparable<T>, R> Sequence<T>.zipRailFence(other: Sequence<R>) =
        this
            .zip(other)
            .sortedBy { it.first }
            .map { it.second }
}
