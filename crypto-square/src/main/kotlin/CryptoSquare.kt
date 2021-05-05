import kotlin.math.ceil
import kotlin.math.sqrt

object CryptoSquare {

    fun ciphertext(plaintext: String): String {

        return plaintext
            .filter { it.isLetterOrDigit() }
            .lowercase()
            .apply { if (isEmpty()) return "" }
            .let {
                val numCols = ceil(sqrt(it.length.toDouble())).toInt()
                transpose(numCols, it.chunked(numCols))
            }
    }

    private fun transpose(numCols: Int, sq: List<String>) = (0 until numCols)
        .joinToString(" ") { i ->
            sq
                .map { it.getOrNull(i) ?: ' ' }
                .joinToString("")
        }
}
