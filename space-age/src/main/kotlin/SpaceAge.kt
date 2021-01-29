class SpaceAge(
     age: Int
){
    private val earthAge = age / 31557600.0

    fun onEarth(): Double = calculateAge(1.0)
    fun onMercury(): Double = calculateAge(0.2408467)
    fun onVenus(): Double = calculateAge(0.61519726)
    fun onMars(): Double = calculateAge(1.8808158)
    fun onJupiter(): Double = calculateAge(11.862615)
    fun onSaturn(): Double = calculateAge(29.447498)
    fun onUranus(): Double = calculateAge(84.016846)
    fun onNeptune(): Double = calculateAge(164.79132)

    private fun calculateAge(planetRatio: Double) = (earthAge / planetRatio).round()

    private fun Double.round(): Double = "%.2f".format(this).toDouble()
}
