object Luhn {

    fun isValid(candidate: String): Boolean {
        val numCandidate = candidate.replace(Regex(" +"), "")
        if (numCandidate.toLongOrNull() == null ||  numCandidate.length < 2) {
            return false
        }
        val result: Int = numCandidate
            .toList()
            .reversed()
            .mapIndexed { index, char -> processEvenDigit(char - '0', index) }
            .reduce { acc, unit -> acc + unit }

        return result % 10 == 0
    }

    private fun processEvenDigit(char: Int, index: Int): Int {
        return if (index % 2 == 1) {
            val multi = char * 2
            if (multi > 9) {
                multi - 9
            } else {
                multi
            }
        } else {
            char
        }
    }
}
