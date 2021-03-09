object BinarySearch {
    fun search(list: List<Int>, item: Int): Int {
        var from = 0
        var to = list.size - 1

        while (from <= to) {
            val mid = (from + to) / 2
            val midVal = list[mid]
            val cResult = compareValues(midVal, item)

            when {
                cResult < 0 -> from = mid + 1
                cResult > 0 -> to = mid - 1
                else -> return mid
            }
        }
        throw NoSuchElementException("Item cannot be not found")
    }
}
