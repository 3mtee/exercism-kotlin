import MeetupSchedule.*
import java.time.DateTimeException
import java.time.DayOfWeek
import java.time.LocalDate

class Meetup(
    private val month: Int,
    private val year: Int
) {
    fun day(dayOfWeek: DayOfWeek, schedule: MeetupSchedule): LocalDate {
        return IntRange(1, 31)
            .asSequence()
            .map {
                try {
                    LocalDate.of(year, month, it)
                } catch (_: DateTimeException) {
                    null
                }
            }
            .filter { it != null && it.dayOfWeek == dayOfWeek && this.doesScheduleMatch(it, schedule) }
            .first()!!

    }

    private fun doesScheduleMatch(date: LocalDate, schedule: MeetupSchedule): Boolean {
        val dayOfMonth = date.dayOfMonth
        return when (schedule) {
            FIRST -> dayOfMonth in 1..7
            SECOND -> dayOfMonth in 8..14
            THIRD -> dayOfMonth in 15..21
            FOURTH -> dayOfMonth in 22..28
            TEENTH -> dayOfMonth in 13..20
            LAST -> dayOfMonth > date.lengthOfMonth() - 7
        }
    }
}

fun main() {
    println(LocalDate.of(2020, 2, 30))
}
