object PigLatin {

    private val vowels = listOf("a", "e", "i", "o", "u", "xr", "yt")
    private val consonantClusters = listOf("ch", "qu", "squ", "thr", "th", "sch", "rh")

    fun translate(phrase: String): String = buildString {
        for (word in phrase.split(" ")) {
            append(convert(word))
            append(" ")
        }
    }.trim()


    private fun convert(phrase: String): String {
        val vowel = vowels.find { phrase.startsWith(it) }
        return if (vowel != null) {
            phrase + "ay"
        } else {
            processConsonantStart(phrase)
        }
    }

    // todo: make it use rules 3 & 4
    private fun processConsonantStart(phrase: String): String {
        val consonantCluster = consonantClusters.find { phrase.startsWith(it) }
        return if (consonantCluster != null) {
            phrase.substring(consonantCluster.length) + consonantCluster + "ay"
        } else {
            phrase.substring(1) + phrase[0] + "ay"
        }
    }
}
