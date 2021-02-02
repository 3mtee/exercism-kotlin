import kotlin.math.pow
import kotlin.math.sqrt

object Darts {

    fun <T : Number> score(x: T, y: T): Int {
        return when (sqrt(x.toDouble().pow(2) + y.toDouble().pow(2))) {
            in 0.0..1.0 -> 10
            in 0.0..5.0 -> 5
            in 0.0..10.0 -> 1
            else -> 0
        }
    }
}
