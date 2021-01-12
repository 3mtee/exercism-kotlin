object Hamming {

    fun compute(leftStrand: String, rightStrand: String): Int {
        if (leftStrand.length != rightStrand.length) {
            throw IllegalArgumentException("left and right strands must be of equal length")
        }

        return leftStrand.toList()
            .foldIndexed(0, { index, acc, char -> if (char != rightStrand[index]) acc + 1 else acc })
    }

}
