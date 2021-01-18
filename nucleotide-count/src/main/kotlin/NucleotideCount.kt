class Dna(dna: String) {

    private val nucleotides = sequenceOf('A', 'C', 'G', 'T')


    val nucleotideCounts: Map<Char, Int> = mapOf(
        'A' to 0,
        'C' to 0,
        'G' to 0,
        'T' to 0
    )
        .plus(
            dna.asSequence()
                .groupingBy {
                    require(nucleotides.contains(it)) { "Incorrect nucleotide!" }
                    it
                }
                .eachCount()
        )

}
