class Matrix(matrixAsString: String) {
    private val matrix: List<List<Int>> = matrixAsString.split("\n")
        .map { it.trim().split(Regex("\\s+")).map(String::toInt) }

    fun column(colNr: Int): List<Int> = matrix.map { it[colNr - 1] }

    fun row(rowNr: Int): List<Int> = matrix[rowNr - 1]
}
