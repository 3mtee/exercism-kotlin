import kotlin.math.ceil
import kotlin.math.sqrt

object CryptoSquare {

    fun ciphertext(plaintext: String): String {
        if (plaintext.isBlank()) {
            return ""
        }
        val normalizedText = plaintext
            .replace(Regex("[^\\w\\d]"), "")
            .toLowerCase()

        val length = normalizedText.length.toDouble()

        val col = ceil(sqrt(length)).toInt()
        val row = ceil(length / col).toInt()
        val matrix = normalizedText
            .padEnd(col * row, ' ')
            .chunked(col)

        return transpose(col, matrix)
            .joinToString(" ") { it.joinToString("") }
    }

    private fun transpose(
        col: Int,
        matrix: List<String>
    ) = (0 until col)
        .map { cIndex ->
            matrix.indices.map { rIndex ->
                matrix[rIndex].getOrNull(cIndex) ?: ' '
            }
        }

}
