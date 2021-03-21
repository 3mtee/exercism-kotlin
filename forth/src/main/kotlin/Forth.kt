class Forth {

    companion object {
        private val OPS: Map<String, (List<Int>) -> List<Int>> = mapOf(
            "+" to {
                require(it.size >= 2) { "tsk-tsk-tsk" }
                it.dropLast(2) + it.takeLast(2).sum()
            },
            "-" to {
                require(it.size >= 2) { "tsk-tsk-tsk" }
                it.dropLast(2) + it.takeLast(2).reduce { acc, i -> acc - i }
            },
            "*" to {
                require(it.size >= 2) { "tsk-tsk-tsk" }
                it.dropLast(2) + it.takeLast(2).reduce { acc, i -> acc * i }
            },
            "/" to {
                require(it.size >= 2 && it[1] != 0) { "tsk-tsk-tsk" }
                it.dropLast(2) + it.takeLast(2).reduce { acc, i -> acc / i }
            },
            "dup" to {
                require(it.isNotEmpty()) { "tsk-tsk-tsk" }
                it + it.last()
            },
            "drop" to {
                require(it.isNotEmpty()) { "tsk-tsk-tsk" }
                it.dropLast(1)
            },
            "swap" to {
                require(it.size >= 2) { "tsk-tsk-tsk" }
                val sub = it.takeLast(2)
                it.dropLast(2) + sub.last() + sub[0]
            },
            "over" to {
                require(it.size >= 2) { "tsk-tsk-tsk" }
                it + it[it.size - 2]
            }
        )
    }

    fun evaluate(vararg line: String) = processReplacements(line.asList())
        .fold(listOf<List<Int>>()) { acc, s -> acc + listOf(evaluateLine(s)) }
        .flatMap { it.toList() }

    private fun processReplacements(lines: List<String>): List<String> {
        val replacements = mutableMapOf<String, String>()
        return lines.mapNotNull {
            val line = it.toLowerCase()
            if (line.matches(Regex(":.*;"))) {
                updateReplacementsMap(line, replacements)
                null
            } else {
                prepareLine(line, replacements)
            }
        }

    }

    private fun updateReplacementsMap(
        line: String,
        replacements: MutableMap<String, String>
    ) {
        val commandDefinition = line.substring(1, line.length - 2).trim()
        val spaceIndex = commandDefinition.indexOf(" ")
        val key = commandDefinition.substring(0, spaceIndex)
        require(key.toDoubleOrNull() == null) { "You can't redefine a number" }
        val value = commandDefinition.substring(spaceIndex + 1)
        replacements[key] = prepareLine(value, replacements)
    }

    private fun prepareLine(line: String, replacements: MutableMap<String, String>) = line.split(" ")
        .map { token ->
            if (replacements.containsKey(token)) {
                replacements[token]
            } else {
                token
            }
        }
        .joinToString(" ")

    private fun evaluateLine(line: String): List<Int> {
        return line.toLowerCase().split(" ")
            .fold(listOf()) { acc, c ->
                when {
                    c.toIntOrNull() != null -> acc + c.toInt()
                    c in OPS.keys -> OPS[c]!!.invoke(acc)
                    else -> throw IllegalArgumentException("Incorrect input")
                }
            }

    }
}
