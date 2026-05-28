val rockPlanets= arrayOf<String>("Mercury","Venus","Earth","Mars")
val gasPlanets= arrayOf("Jupiter","Saturn","Uranus","Neptune")
val solarSystem=rockPlanets+gasPlanets

fun main() {
    val solarSystem= mutableMapOf(
        "Mercury" to 0,
        "Venus" to 0,
        "Earth" to 1,
        "Mars" to 2,
        "Jupiter" to 79,
        "Saturn" to 82,
        "Uranus" to 27,
        "Neptune" to 14

    )
    println(solarSystem.size)
    solarSystem["Pluto"]=5
    println(solarSystem["Pluto"])
    println(solarSystem.get("Theia"))
    solarSystem["Jupiter"]=78
    println(solarSystem["Jupiter"])
}