object RunLengthEncoding {

    fun encode(input: String): String = input
        .replace(Regex("(.)\\1+")) {
            "${it.value.length}${it.groupValues[1]}"
        }

    fun decode(input: String): String = input
        .replace(Regex("(\\d+)(.)")) {
            it.groupValues[2].repeat(it.groupValues[1].toInt())
        }
}
