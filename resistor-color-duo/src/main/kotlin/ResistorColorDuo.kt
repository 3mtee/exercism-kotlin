object ResistorColorDuo {

    fun value(vararg colors: Color): Int =
        colors.take(2).map { it.ordinal.toString() }.reduce { acc, s -> acc + s }.toInt()
}
