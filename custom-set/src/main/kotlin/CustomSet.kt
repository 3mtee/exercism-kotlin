class CustomSet(vararg input: Int) {

    private val data = mutableSetOf(*input.toTypedArray())

    fun isEmpty(): Boolean = data.isEmpty()

    fun isSubset(other: CustomSet): Boolean = other.data.containsAll(data)

    fun isDisjoint(other: CustomSet): Boolean = intersection(other).data.isEmpty()

    fun contains(other: Int): Boolean = data.contains(other)

    fun intersection(other: CustomSet): CustomSet {
        val copy = mutableSetOf(*data.toTypedArray())
        copy.retainAll(other.data)
        val elements = copy.toIntArray()
        return CustomSet(*elements)
    }

    fun add(other: Int) = data.add(other)

    override fun equals(other: Any?): Boolean {
        if (other !is CustomSet) {
            return false
        }
        return data == other.data
    }

    operator fun plus(other: CustomSet): CustomSet {
        data.addAll(other.data)
        return this
    }

    operator fun minus(other: CustomSet): CustomSet {
        data.removeAll(other.data)
        return this
    }

    override fun hashCode(): Int = data.hashCode()
}
