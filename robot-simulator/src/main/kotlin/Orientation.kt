enum class Orientation {

    NORTH,
    EAST,
    SOUTH,
    WEST;

    fun rotateLeft() = with(this.ordinal - 1) {
        val newOrdinal = if (this < 0) {
            this + values().size
        } else {
            this
        }
        values()[newOrdinal]
    }

    fun rotateRight() = with(this.ordinal + 1) {
        val newOrdinal = if (this > values().size - 1) {
            this - values().size
        } else {
            this
        }
        values()[newOrdinal]
    }

}
