internal enum class RomanNumeral(val value: Int) {
    M(1000),
    CM(900),
    D(500),
    CD(400),
    C(100),
    XC(90),
    L(50),
    XL(40),
    X(10),
    IX(9),
    V(5),
    IV(4),
    I(1)
}

object RomanNumerals {

    fun value(n: Int): String {
        var number = n
        val romans = RomanNumeral.values()
        val result = StringBuilder()

        var i = 0
        while (number > 0 && i < romans.size) {
            val currentSymbol = romans[i]
            if (currentSymbol.value <= number) {
                result.append(currentSymbol.name)
                number -= currentSymbol.value
            } else {
                i++
            }
        }
        return result.toString()
    }
}
