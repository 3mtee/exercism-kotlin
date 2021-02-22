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

    private fun generateName(): String {
        do {
            val name = NAMES.addAndReturn(CHAR_POOL.randomChars(2) + NUM_POOL.randomChars(3))
            if (name != null) return name
        } while (name == null)
        return ""
    }

    private fun MutableSet<String>.addAndReturn(element: String): String? = if (this.add(element)) element else null

    fun reset() {
        name = generateName()
    }
}

private fun CharRange.randomChars(count: Int) = (1..count)
    .map { elementAt(Random.nextInt(count())) }
    .joinToString("")

