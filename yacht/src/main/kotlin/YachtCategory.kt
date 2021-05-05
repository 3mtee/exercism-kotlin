internal fun countDices(dices: List<Int>, digit: Int) = dices.filter { it == digit }.sum()

enum class YachtCategory(val score: (dices: List<Int>) -> Int) {
    YACHT({ if (it.toSet().size == 1) 50 else 0 }),
    ONES({ countDices(it, 1) }),
    TWOS({ countDices(it, 2) }),
    THREES({ countDices(it, 3) }),
    FOURS({ countDices(it, 4) }),
    FIVES({ countDices(it, 5) }),
    SIXES({ countDices(it, 6) }),
    FULL_HOUSE({ dices ->
        dices
            .groupingBy { it }
            .eachCount()
            .let {
                if (it.values.toSet() != setOf(2,3)) {
                    emptyMap()
                } else {
                    it
                }
            }
            .entries
            .filter { it.value == 2 || it.value == 3 }
            .sumOf { it.key * it.value }
    }),
    FOUR_OF_A_KIND({ dices ->
        dices
            .groupingBy { it }
            .eachCount()
            .entries
            .filter { it.value >= 4 }
            .sumOf { it.key * 4 }
    }),
    LITTLE_STRAIGHT({ if (it.sorted() == listOf(1, 2, 3, 4, 5)) 30 else 0 }),
    BIG_STRAIGHT({ if (it.sorted() == listOf(2, 3, 4, 5, 6)) 30 else 0 }),
    CHOICE({ it.sum() })

}
