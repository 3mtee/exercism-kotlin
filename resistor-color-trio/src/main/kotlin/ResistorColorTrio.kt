import kotlin.math.log
import kotlin.math.pow

object ResistorColorTrio {

    fun text(vararg input: Color): String = input
        .foldIndexed("") { index, acc, color ->
            acc + if (index < 2) color.ordinal else "0".repeat(color.ordinal)
        }
        .run { toInt() }
        .run { formatResistance(this) }

    private fun formatResistance(value: Int): String {
        val unitOrdinal = log(value.toDouble(), 1000.0).toInt()
        val unit = Unit.values()[unitOrdinal].name.lowercase()
        val n = value / 1_000.0.pow(unitOrdinal).toInt()
        return "$n $unit"
    }
}
