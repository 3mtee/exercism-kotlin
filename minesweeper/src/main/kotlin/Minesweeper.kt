class MinesweeperBoard(private val board: List<String>) {
    fun withNumbers(): List<String> =
        board
            .mapIndexed { row, str ->
                str
                    .mapIndexed { col, cell -> markCell(cell, row, col) }
                    .joinToString("")
            }

    private fun markCell(cell: Char, row: Int, col: Int) = if (cell == ' ') adjacentMines(row, col) else cell

    private fun adjacentMines(row: Int, col: Int): Char {
        val minRowIndex = 0.coerceAtLeast(row - 1)
        val maxRowIndex = (board.size - 1).coerceAtMost(row + 1)
        val minColIndex = 0.coerceAtLeast(col - 1)
        val maxColIndex = (board[0].length - 1).coerceAtMost(col + 1)

        val count = IntRange(minRowIndex, maxRowIndex)
            .flatMap { i ->
                IntRange(minColIndex, maxColIndex)
                    .map { j ->
                        if (board[i][j] == '*') 1 else 0
                    }
            }
            .sum()

        return if (count > 0) count.getChar() else ' '
    }

    private fun Int.getChar() = (this + '0'.toInt()).toChar()
}
