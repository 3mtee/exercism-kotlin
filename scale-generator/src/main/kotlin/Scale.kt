class Scale(private val tonic: String) {

    fun chromatic(): List<String> = if (tonic.getOrNull(1) == '#') {
        listOf("C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B")
    } else {
        listOf("F", "Gb", "G", "Ab", "A", "Bb", "B", "C", "Db", "D", "Eb", "E")
    }
        .run { cycleNotes() }

    private fun List<String>.cycleNotes() =
        dropWhile { it.toUpperCase() != tonic.toUpperCase() } + takeWhile { it.toUpperCase() != tonic.toUpperCase() }

    fun interval(intervals: String): List<String> =
        intervals
            .scan(0) { x, y -> x + "mMA".indexOf(y) + 1 }
            .mapNotNull { chromatic().getOrNull(it) }
}
