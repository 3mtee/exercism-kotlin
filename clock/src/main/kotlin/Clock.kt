import java.text.SimpleDateFormat
import java.util.*
import java.util.Calendar.*

class Clock(hour: Int, minute: Int) {

    var time: Calendar = getInstance()

    init {
        time.set(HOUR_OF_DAY, hour)
        time.set(MINUTE, minute)
    }

    fun subtract(minutes: Int) = time.add(MINUTE, -minutes)

    fun add(minutes: Int) = time.add(MINUTE, minutes)

    override fun toString(): String = SimpleDateFormat("HH:mm").format(time.time)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Clock) return false
        return time.get(HOUR_OF_DAY) == other.time.get(HOUR_OF_DAY) && time.get(MINUTE) == other.time.get(MINUTE)
    }

    override fun hashCode() = time.hashCode()
}
