fun <T> List<T>.customAppend(list: List<T>) = list.customFoldLeft(this) { acc, item -> acc + listOf(item) }

fun <E> List<E>.customConcat(): List<Any> = this.customFoldLeft(listOf()) { acc, item ->
    when (item) {
        is List<*> -> acc.plus(item.customConcat())
        null -> acc
        else -> acc + listOf(item)
    }
}


fun <T> List<T>.customFilter(predicate: (T) -> Boolean) =
    customFoldLeft(listOf<T>()) { acc, itm -> if (predicate(itm)) acc + itm else acc }

val List<Any>.customSize: Int get() = customFoldLeft(0) { acc, _ -> acc.inc() }

fun <T, U> List<T>.customMap(transform: (T) -> U) =
    customFoldLeft(listOf<U>()) { acc, itm -> acc + transform(itm) }

fun <T, U> List<T>.customFoldLeft(initial: U, f: (U, T) -> U): U =
    if (isEmpty()) initial else drop(1).customFoldLeft(f(initial, first()), f)

fun <T, U> List<T>.customFoldRight(initial: U, f: (T, U) -> U) =
    this.customReverse().customFoldLeft(initial) { acc, item -> f(item, acc) }

fun <T> List<T>.customReverse() = customFoldLeft(listOf<T>()) { acc, item -> listOf(item) + acc }
