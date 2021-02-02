import kotlin.math.hypot

object Darts {

    fun score(x: Number, y: Number): Int {
        return when (hypot(x.toDouble(), y.toDouble())) {
            in 0.0..1.0 -> 10
            in 0.0..5.0 -> 5
            in 0.0..10.0 -> 1
            else -> 0
        }
    }
}
