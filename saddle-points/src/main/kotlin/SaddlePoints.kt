class Matrix(private val matrix: List<List<Int>>) {

    val saddlePoints: Set<MatrixCoordinate>
        get() {
            val result = mutableSetOf<MatrixCoordinate>()
            matrix.forEachIndexed { i, row ->
                row.forEachIndexed { j, v ->
                    if (isSaddlePoint(v, row, j)) {
                        result.add(MatrixCoordinate(i + 1, j + 1))
                    }
                }
            }
            return result
        }

    private fun isSaddlePoint(value: Int, row: List<Int>, colIndex: Int) =
        value == row.maxOrNull() && value == matrix.map { it[colIndex] }.minOrNull()
}

data class MatrixCoordinate(val row: Int, val col: Int)
