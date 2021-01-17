class Series(input: String) {

    private val digits: List<Int> = input.map {
        require(it.isDigit()) { "Input contains non-digits" }
        it - '0'
    }

    fun getLargestProduct(span: Int): Long {
        if (span == 0) {
            return 1
        }
        require(span > 0) { "Negative span is forbidden" }
        require(span <= digits.count()) { "Span shouldn't exceed the size of the input" }

        return digits
            .windowed(span) { it.fold(1L) { acc, d -> acc * d } }
            .maxOrNull() ?: 0
    }
}
