object BeerSong {
    fun verses(startBottles: Int, takeDown: Int) = buildString {
        var bottlesLeft = startBottles
        do {
            append(makeBottlesPhrase(bottlesLeft, true))
                .append(" of beer on the wall, ${makeBottlesPhrase(bottlesLeft)} of beer.")
                .append("\n")

            val subtractee = if (--bottlesLeft == 0) "it" else "one"
            if (bottlesLeft >= 0) {
                append("Take $subtractee down and pass it around, ")
                    .append(makeBottlesPhrase(bottlesLeft))
                    .append(" of beer on the wall.\n")
            } else {
                append("Go to the store and buy some more, 99 bottles of beer on the wall.\n")
            }
            if (bottlesLeft >= takeDown) {
                append("\n")
            }
        } while (bottlesLeft >= takeDown)

    }

    private fun makeBottlesPhrase(count: Int, capitalize: Boolean = false): String {
        val phrase = when {
            count == 1 -> "1 bottle"
            count <= 0 -> "no more bottles"
            else -> "$count bottles"
        }
        return if (capitalize) phrase.capitalize() else phrase
    }
}
