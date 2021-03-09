object Yacht {

    fun solve(category: YachtCategory, vararg dices: Int) = category.score(dices.toList())
}
