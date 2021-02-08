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
        var newName: String
        do {
            newName = CHAR_POOL.randomChars(2) + NUM_POOL.randomChars(3)
        } while (newName in NAMES)

        NAMES.add(newName)
        return newName
    }

    fun reset() {
        name = generateName()
    }
}

private fun CharRange.randomChars(count: Int) = (1..count)
    .map { elementAt(Random.nextInt(count())) }
    .joinToString("")

