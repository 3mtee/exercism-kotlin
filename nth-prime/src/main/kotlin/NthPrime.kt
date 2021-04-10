import kotlin.math.sqrt

object Prime {
    fun nth(n: Int): Int {
        require(n > 0) { "There is no zeroth prime." }
        return generateSequence(1) { it + 1 }
            .filterNot { value -> (2..sqrt(value.toDouble()).toInt()).any { value % it == 0 } }
            .elementAt(n)
    }
}
