class Triangle<out T : Number>(sideA: T, sideB: T, sideC: T) {

    private val a = sideA.toDouble()
    private val b = sideB.toDouble()
    private val c = sideC.toDouble()
    private val sortedSides = listOf(a, b, c).sorted()
    private val minSidesSum = sortedSides.take(2).sumOf { it }

    init {
        require(a > 0 && b > 0 && c > 0) { "All sides need to be greater than 0" }
        require(minSidesSum >= sortedSides.last()) { "That's not a triangle!" }
    }
    private val uniqueSideCount = setOf(a, b, c).size

    val isEquilateral: Boolean = uniqueSideCount == 1
    val isIsosceles: Boolean = uniqueSideCount < 3
    val isScalene: Boolean = uniqueSideCount == 3
    val isDegenerate: Boolean = minSidesSum == sortedSides.last()
}
