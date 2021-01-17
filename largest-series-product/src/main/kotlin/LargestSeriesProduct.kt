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
        val count = this.digits.count()
        require(span <= count) { "Span shouldn't exceed the size of the input" }

        var result = 0L
        for (i in 0..count - span) {
            result = digits.subList(i, i + span)
                .reduce { acc, d -> acc * d }
                .toLong()
                .takeIf { it > result } ?: result
        }
        return result
    }
}
