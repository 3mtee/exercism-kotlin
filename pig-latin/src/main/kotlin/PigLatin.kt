object PigLatin {


    fun translate(phrase: String): String =
        Regex("""
            (?:
                (?<vowel>[aeiou]|xr|yt)                 # vowels
                    |
                (?<consonant>ch|rh|\w?qu|thr?|sch|\w)   # consonants
            )                                           # a non-capturing group to capture either vowels or consonants
            (?<body>\w+)                                # unmodifiable part of the word 
            """.trimIndent(), RegexOption.COMMENTS)
            .replace(phrase, "\${vowel}\${body}\${consonant}ay")
}
