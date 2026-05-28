class FillInTheBlankQuestion(
    val questionText: String,
    val answer: String,
    val difficulty: String
)

class TrueOrFalseQuestion(
    val questionText: String,
    val answer: Boolean,
    val difficulty: String
)

class NumericQuestion(
    val questionText: String,
    val answer: Int,
    val difficulty: String
)

data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)

enum class Difficulty{
    EASY,
    MADIUM,
    HARD
}

interface ProgressPrintable{
    val progressText:String
    fun printProgressBar()
}

class Quiz:ProgressPrintable{

    fun printQuiz() {
        question1.let {
            println((it.questionText))
            println(it.answer)
            println(it.difficultly)
        }
        println()
        question2.let {
            println((it.questionText))
            println(it.answer)
            println(it.difficultly)
        }
        println()
        question3.let {
            println((it.questionText))
            println(it.answer)
            println(it.difficultly)
        }
        println()
    }
    override fun printProgressBar() {
        repeat(Quiz.answered){ println(" ") }
        repeat(Quiz.total-Quiz.answered){ println(" ") }
        println()
        println(progressText)
    }
    override val progressText:String
        get()="${answered} of ${total} answered"
    val question1 = Question<String>(
        "Речка спятила с ума - По домам пошла сама. ___",
        "водопровод",
        Difficulty.MADIUM
    )
    val question2 = Question<Boolean>(
        "Небо зеленое. Правда или ложь",
        false,
        Difficulty.EASY
    )
    val question3 = Question<Int>(
        "Сколько дней между полнолуниями?",
        28,
        Difficulty.HARD
    )
    companion object StudentProgress{
        var total:Int=10
        var answered:Int=3
    }
}

fun main(){
    val quiz=Quiz().apply { printQuiz() }
}
