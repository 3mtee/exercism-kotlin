object MatchingBrackets {
    private val bracketMap = mapOf(
        ')' to '(',
        ']' to '[',
        '}' to '{'
    )

    fun isValid(input: String): Boolean {
        val brackets = mutableListOf<Char>()
        input.asIterable().forEach {
            when (it) {
                in "([{" -> brackets.add(it)
                in ")]}" -> {
                    if (brackets.isNotEmpty() && brackets.last() == bracketMap[it]) {
                        brackets.removeLast()
                    } else {
                        return false
                    }
                }
            }
        }
        return brackets.isEmpty()
    }

}
