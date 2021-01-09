object Acronym {
    fun generate(phrase: String): String {
        return phrase
            .split(" ", "-")
            .map {
                val trim = Regex("[^A-Za-z]").replace(it, "").trim()
                if (trim.isNotEmpty()) trim[0] else ""
            }
            .joinToString(separator = "")
            .toUpperCase()
    }
}
