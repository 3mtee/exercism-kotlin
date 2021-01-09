import kotlin.random.Random

class DndCharacter {

    val strength: Int = ability()
    val dexterity: Int = ability()
    val constitution: Int = ability()
    val intelligence: Int = ability()
    val wisdom: Int = ability()
    val charisma: Int = ability()
    val hitpoints: Int = 10 + modifier(constitution)

    companion object {

        fun ability(): Int = (0..3)
            .map { Random.nextInt(1, 7) }
            .sortedDescending()
            .dropLast(1)
            .sum()

        fun modifier(score: Int): Int = score / 2 - 5 // same as "score / 2 - 10 / 2"
    }

}
