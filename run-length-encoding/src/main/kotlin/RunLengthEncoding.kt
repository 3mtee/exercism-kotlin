object RunLengthEncoding {

    fun encode(input: String): String {
        return input
            .asSequence()
            .zipWithNext()
            .foldIndexed(mutableListOf<MutableList<Char>>()) { index, acc, data ->
                if (acc.isEmpty()) {
                    acc.add(mutableListOf())
                }
                acc.last().add(data.first)
                if (data.first != data.second) {
                    acc.add(mutableListOf())
                }
                if (index == input.length - 2) {
                    acc.last().add(data.second)
                }
                acc
            }
            .joinToString("") { "${if (it.size > 1) it.size else ""}${it.first()}" }
    }

    fun decode(input: String): String = input.replace(Regex("(\\d+)(.)")) {
        it.groupValues[2].repeat(it.groupValues[1].toInt())
    }
}
