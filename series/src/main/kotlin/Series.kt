object Series {

    fun slices(n: Int, s: String): List<List<Int>> {
        require(s.isNotEmpty()) { "Empty series is forbidden" }
        require(n <= s.length) { "Slice size shouldn't exceed that of a series" }
        return s
            .map { it - '0' }
            .windowed(n)
    }
}
