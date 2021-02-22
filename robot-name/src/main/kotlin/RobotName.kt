import kotlin.random.Random

class Robot {

    companion object {
        @JvmStatic
        private val CHAR_POOL = ('A'..'Z')

        @JvmStatic
        private val NUM_POOL = ('0'..'9')

        private val NAMES = mutableSetOf<String>()
    }

    var name: String = generateName()

    private fun generateName(): String = CHAR_POOL.randomChars(2)
        .plus(NUM_POOL.randomChars(3))
        .let {
            if (it in NAMES) {
                generateName()
            } else {
                NAMES.add(it)
                it
            }
        }

    fun reset() {
        name = generateName()
    }
}

private fun CharRange.randomChars(count: Int) = (1..count)
    .map { elementAt(Random.nextInt(count())) }
    .joinToString("")

