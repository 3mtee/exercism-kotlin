class IsbnVerifier {

    fun isValid(isbn: String): Boolean {
        val cleanIsbn = isbn.replace("-", "")
        if (!cleanIsbn.matches(Regex("[0-9]{9}([0-9]|X)$"))) {
            return false
        }
        return cleanIsbn
            .map { if (it == 'X') 10 else it - '0' }
            .zip(10 downTo 0)
            .fold(0) { acc, pair ->
                acc + pair.first * pair.second
            } % 11 == 0
    }
}
