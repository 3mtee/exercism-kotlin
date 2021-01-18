class PhoneNumber(input: String) {
    private val areaCode: String
    private val exchange: String
    private val subscriber: String

    init {
        val groupValues = try {
            Regex(
                "^\\+?1?" + //country
                    "[-. (]*([2-9]\\d{2})\\)?" + //areaCode
                    "[-. (]*([2-9]\\d{2})\\)?" + //exchange
                    "[-. (]*(\\d{4})\\)?\$" // subscriber
            )
                .find(input.trim())!!.groupValues
        } catch (e: NullPointerException) {
            throw IllegalArgumentException("Incorrect input")
        }

        this.areaCode = groupValues[1]
        this.exchange = groupValues[2]
        this.subscriber = groupValues[3]
    }

    val number: String = "$areaCode$exchange$subscriber"
}
