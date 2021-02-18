class ChainNotFoundException(msg: String) : RuntimeException(msg)

data class Domino(val left: Int, val right: Int) {
    fun isDouble() = left == right
    fun swap() = Domino(right, left)
}

object Dominoes {

    fun formChain(vararg inputDominoes: Domino): List<Domino> = formChain(inputDominoes.toList())

    fun formChain(inputDominoes: List<Domino>): List<Domino> = when (inputDominoes.size) {
        0 -> emptyList()
        1 -> processSingleDomino(inputDominoes)
        else -> buildChain(inputDominoes)
    }

    private fun buildChain(dominoes: List<Domino>): List<Domino> {
        dominoes
            .drop(1)
            .permutate()
            .fold(mutableListOf(dominoes.first())) { acc, seq ->
                check@ for (tile in seq) {
                    when (acc.last().right) {
                        tile.left -> acc.add(tile)
                        tile.right -> acc.add(tile.swap())
                        else -> break@check
                    }
                }

                if (acc.first().left == acc.last().right && acc.size == dominoes.size) {
                    return acc.toList()
                } else {
                    acc.clear()
                    acc.add(dominoes.first())
                }

                acc
            }

        throw ChainNotFoundException("Chain not found.")
    }

    private fun <T> List<T>.permutate(): List<List<T>> {
        if (this.size == 1) return listOf(this)
        val result = mutableListOf<List<T>>()
        val toInsert = this[0]
        for (perm in this.drop(1).permutate()) {
            for (i in 0..perm.size) {
                val newPerm = perm.toMutableList()
                newPerm.add(i, toInsert)
                result.add(newPerm)
            }
        }
        return result
    }

    private fun processSingleDomino(inputDominoes: List<Domino>) =
        if (inputDominoes.first().isDouble()) {
            inputDominoes
        } else {
            throw ChainNotFoundException("Incorrect input")
        }
}
