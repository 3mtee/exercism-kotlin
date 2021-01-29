import PlanetAge.*

class SpaceAge(
    age: Int
) {

    companion object {
        private const val EARTH_SECONDS = 31557600.0
    }

    private val earthAge = age / Companion.EARTH_SECONDS
    fun onEarth(): Double = calculateAge(EARTH)
    fun onMercury(): Double = calculateAge(MERCURY)
    fun onVenus(): Double = calculateAge(VENUS)
    fun onMars(): Double = calculateAge(MARS)
    fun onJupiter(): Double = calculateAge(JUPITER)
    fun onSaturn(): Double = calculateAge(SATURN)
    fun onUranus(): Double = calculateAge(URANUS)
    fun onNeptune(): Double = calculateAge(NEPTUNE)

    private fun calculateAge(planet: PlanetAge) = (earthAge / planet.earthRatio).round()

    private fun Double.round(): Double = "%.2f".format(this).toDouble()
}

enum class PlanetAge(val earthRatio: Double) {
    EARTH(1.0),
    MERCURY(0.2408467),
    VENUS(0.61519726),
    MARS(1.8808158),
    JUPITER(11.862615),
    SATURN(29.447498),
    URANUS(84.016846),
    NEPTUNE(164.79132)
}
