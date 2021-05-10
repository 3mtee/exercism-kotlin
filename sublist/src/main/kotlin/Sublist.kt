import Relationship.*

enum class Relationship {
    EQUAL, SUBLIST, SUPERLIST, UNEQUAL
}

fun <T> List<T>.relationshipTo(other: List<T>) = when {
    this == other -> EQUAL
    this.isEmpty() || other.windowed(this.size).contains(this) -> SUBLIST
    other.isEmpty() || this.windowed(other.size).contains(other) -> SUPERLIST
    else -> UNEQUAL
}
