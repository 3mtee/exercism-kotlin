import kotlin.math.pow

object Wordy {
    private const val PREFIX = "What is "
    private const val SUFFIX = "?"

    private val operations = mapOf<String, (a: Int, b: Int) -> Int>(
        "+" to { a, b -> a + b },
        "-" to { a, b -> a - b },
        "*" to { a, b -> a * b },
        "/" to { a, b -> a / b },
        "^" to { a, b -> a.toDouble().pow(b).toInt() },
    )


    fun answer(input: String): Int {
        return clearInput(input)
            .also { validateInput(it) }
            .split(" ")
            .asSequence()
            .also { if (it.count() == 1) return it.first().toInt() }
            .zipWithNext()
            .foldIndexed(0) { index, acc, piece ->
                when {
                    index == 0 -> piece.first.toInt()
                    index % 2 == 1 -> operations[piece.first]!!.invoke(acc, piece.second.toInt())
                    else -> acc
                }
            }
    }

    private fun validateInput(input: String) {
        if (!input.matches(Regex("^-?\\d+( [+\\-*/^] -?\\d+)*"))) {
            throw IllegalArgumentException("Wrong input")
        }
    }

    private fun clearInput(input: String): String = input
        .replace(PREFIX, "")
        .replace("plus", "+")
        .replace("minus", "-")
        .replace("multiplied by", "*")
        .replace("divided by", "/")
        .replace(Regex("raised to the (\\d+)th power"), "^ $1")
        .replace(SUFFIX, "")
}

