private val alphabet = 'a'..'z'
private fun generateKey() = (1..100).map { alphabet.random() }.joinToString("")


data class Cipher(val key: String = generateKey()) {
    init {
        require(key.isNotEmpty() && key.all { it.isLetter() && it.isLowerCase() }) { "Incorrect key" }
    }

    fun encode(s: String): String {
        return doStuff(s, false)
    }

    fun decode(s: String): String {
        return doStuff(s, true)
    }

    private fun doStuff(text: String, decode: Boolean) = text.zip(chooseKey(text))
        .map { getChar(it, decode) }
        .joinToString("")

    private fun chooseKey(text: String) = if (key.length < text.length) {
        key.repeat(text.length / key.length + 1)
    } else {
        key
    }
        .substring(0, text.length)

    private fun getChar(pair: Pair<Char, Char>, decode: Boolean): Char {
        val index = if (decode) {
            alphabet.indexOf(pair.first) - alphabet.indexOf(pair.second)
        } else {
            alphabet.indexOf(pair.first) + alphabet.indexOf(pair.second)
        }
            .let { it % alphabet.count() }
            .let {
                if (it >= 0) it else it + alphabet.count()
            }
        return alphabet.elementAt(index)
    }
}
