object Transpose {

    fun transpose(input: List<String>): List<String> {
        return (0 until getLongestWordLength(input))
            .map { column ->
                input.indices.map { row ->
                    input[row].getOrNull(column) ?: padOutput(column, input, row)
                }
            }
            .map { it.joinToString("") }
    }

    private fun padOutput(
        column: Int,
        input: List<String>,
        row: Int
    ) = if (column < getLongestWordLength(input.drop(row + 1))) " " else ""

    private fun getLongestWordLength(input: List<String>) = input.maxByOrNull { it.length }?.length ?: 0
}
