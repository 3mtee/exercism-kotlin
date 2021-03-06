enum class Classification {
    DEFICIENT, PERFECT, ABUNDANT
}

fun classify(naturalNumber: Int) =
    if (naturalNumber < 1) {
        throw IllegalArgumentException("Incorrect input!")
    } else {
        (1 until naturalNumber)
            .sumBy { if (naturalNumber % it == 0) it else 0 }
            .let {
                when {
                    it == naturalNumber -> Classification.PERFECT
                    it > naturalNumber -> Classification.ABUNDANT
                    else -> Classification.DEFICIENT
                }
            }
    }
