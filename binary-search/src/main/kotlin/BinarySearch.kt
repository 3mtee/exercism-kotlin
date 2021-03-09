object BinarySearch {
    fun search(list: List<Int>, item: Int) = list
        .binarySearch(item)
        .let { if (it < 0) throw NoSuchElementException("Item cannot be found") else it }
}
