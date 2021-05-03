import java.util.*

class School {

    private val roster = TreeMap<Int, MutableList<String>>()

    fun add(student: String, grade: Int) {
        val gradeRoster = roster.getOrPut(grade) { mutableListOf() }
        gradeRoster.add(student)
        gradeRoster.sort()
    }

    fun grade(grade: Int) = roster[grade]?.toList() ?: emptyList()

    fun roster() = roster.values.flatMap { it.toList() }
}
