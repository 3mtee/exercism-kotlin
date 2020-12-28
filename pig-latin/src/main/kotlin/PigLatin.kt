object PigLatin {

    private val vowels = listOf("a", "e", "i", "o", "u", "xr", "yt")
    private const val ruleThreeConsonant = "qu"
    private const val suffix = "ay"

    private val consonantClusters = listOf("ch", ruleThreeConsonant, "thr", "th", "sch", "rh")
    fun translate(phrase: String): String = buildString {
        for (word in phrase.split(" ")) {
            append(convert(word))
            append(" ")
        }
    }.trim()

    private fun convert(word: String): String {
        val vowel = vowels.find { word.startsWith(it) }
        return if (vowel != null) {
            word + suffix
        } else {
            processConsonantStart(word)
        }
    }

    private fun processConsonantStart(word: String): String = buildString {
        val consonant = StringBuilder()
        val consonantCluster = consonantClusters.find { word.startsWith(it) }
        if (consonantCluster != null) {
            consonant.append(consonantCluster)
        } else {
            consonant.append(word[0])
        }
        val consonantlessWord = StringBuilder(word.substring(consonant.length))
        if (consonantlessWord.startsWith(ruleThreeConsonant)) {
            consonantlessWord.delete(0, 2)
            consonant.append(ruleThreeConsonant)
        }

        append(consonantlessWord)
        append(consonant)
        append(suffix)

    }
}
