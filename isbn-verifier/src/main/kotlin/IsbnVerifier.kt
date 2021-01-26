class IsbnVerifier {

    fun isValid(isbn: String): Boolean {
        val cleanIsbn = isbn.replace("-", "")
        if (!cleanIsbn.matches(Regex("[0-9]{9}([0-9]|X)$"))) {
            return false
        }
        return cleanIsbn
            .map { if (it == 'X') 10 else it - '0' }
            .foldIndexed(0) { index, acc, i -> acc + i * (10 - index) }
            .rem(11) == 0
    }
}
