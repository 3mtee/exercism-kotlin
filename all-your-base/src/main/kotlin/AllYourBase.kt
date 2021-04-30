class BaseConverter(private val base: Int, digits: IntArray) {
    init {
        require(base > 1) { "Bases must be at least 2." }
        require(digits.isNotEmpty()) { "You must supply at least one digit." }
        require(digits[0] != 0 || digits.size == 1) { "Digits may not contain leading zeros." }
        require(digits.all { it >= 0 }) { "Digits may not be negative." }
        require(digits.all { it < base }) { "All digits must be strictly less than the base." }
    }

    private val decValue = digits.fold(0) { acc, i -> acc * base + i }

    fun convertToBase(newBase: Int, number: Int = decValue): IntArray {
        require(newBase > 1) { "Bases must be at least 2." }
        return if (number < newBase) {
            intArrayOf(number)
        } else {
            convertToBase(newBase, number / newBase) + number % newBase
        }
    }
}
