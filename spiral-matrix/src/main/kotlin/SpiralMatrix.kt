object SpiralMatrix {

    fun ofSize(size: Int): Array<IntArray> {
        val matrix = Array(size) { IntArray(size) }

        var startRow = 0
        var endRow = size - 1
        var startCol = 0
        var endCol = size - 1
        var number = 1
        while (number <= size * size) {
            for (i in startCol..endCol) matrix[startRow][i] = number++
            for (i in ++startRow..endRow) matrix[i][endCol] = number++
            for (i in --endCol downTo startCol) matrix[endRow][i] = number++
            for (i in --endRow downTo startRow) matrix[i][startCol] = number++

            startCol++
        }

        return matrix

    }
}
