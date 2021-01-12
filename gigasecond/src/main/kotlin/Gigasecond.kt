import java.time.LocalDate
import java.time.LocalDateTime

class Gigasecond constructor(dateTime: LocalDateTime) {
    val date: LocalDateTime = dateTime
        get() = field.plusSeconds(1_000_000_000)

    constructor(date: LocalDate) : this(date.atStartOfDay())

}
