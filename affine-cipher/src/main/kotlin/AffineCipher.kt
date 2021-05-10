object AffineCipher {

    private val alphabet = 'a'..'z'
    private val alphabetSize = alphabet.count()

    fun encode(input: String, a: Int, b: Int) =
        input
            .let {
                require(a.isCoprimeWith(alphabetSize)) { "a and m must be coprime." }
                it
            }
            .lowercase()
            .filter { it.isLetterOrDigit() }
            .map {
                when (val charIndex = alphabet.indexOf(it)) {
                    -1 -> it
                    else -> alphabet.elementAt((charIndex * a + b).floorMod(alphabetSize))
                }

            }
            .windowed(5, 5, true) { it.joinToString("") }
            .joinToString(" ")

    fun decode(input: String, a: Int, b: Int): String {
        return input
            .let {
                require(a.isCoprimeWith(alphabetSize)) { "a and m must be coprime." }
                it
            }
            .filter { it.isLetterOrDigit() }
            .map {
                when (val eCharIndex = alphabet.indexOf(it)) {
                    -1 -> it
                    else -> alphabet.elementAt((a.mmi(alphabetSize) * (eCharIndex - b)).floorMod(alphabetSize))
                }

            }.joinToString("")
    }
}

private fun Int.isCoprimeWith(other: Int): Boolean = this.gcd(other) == 1

private tailrec fun Int.gcd(b: Int): Int = if (b == 0) this else b.gcd(this % b)


private fun Int.floorMod(m: Int): Int = (this % m + m) % m

private fun Int.mmi(m: Int): Int = (0 until m).first { (this * it).floorMod(m) == 1 }

