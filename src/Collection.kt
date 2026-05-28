val rockPlanets= arrayOf<String>("Mercury","Venus","Earth","Mars")
val gasPlanets= arrayOf("Jupiter","Saturn","Uranus","Neptune")
val solarSystem=rockPlanets+gasPlanets

fun main(){
    val solarSystem= mutableListOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
    for (planet in solarSystem){
        println(planet)
    }
}