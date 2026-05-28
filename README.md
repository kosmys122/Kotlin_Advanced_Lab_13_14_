README.md для лабораторной работы №13-14
Вот обновлённое содержимое файла README.md с описанием и примерами всех изученных тем:

markdown
# Лабораторная работа №13-14
## Коллекции, обобщения и функциональный стиль в Kotlin

## Описание

Данная лабораторная работа посвящена изучению продвинутых возможностей языка Kotlin, которые активно используются при разработке Android-приложений. В рамках работы рассматриваются:

- обобщённые типы (Generics);
- коллекции Kotlin (Array, List, Set, Map);
- функции высшего порядка;
- extension-функции и свойства;
- scope-функции;
- интерфейсы;
- перечисления (enum class);
- классы данных (data class);
- singleton-объекты (object и companion object).

Все примеры ориентированы на практическое применение и подготовку к разработке мобильных приложений.

## Изученные темы и примеры

### 1. Generics (обобщённые типы)

Позволяют создавать универсальные классы, работающие с разными типами данных:

```kotlin
class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)

val question1 = Question<String>("Что такое Kotlin?", "Язык программирования", Difficulty.EASY)
val question2 = Question<Boolean>("Kotlin совместим с Java?", true, Difficulty.MEDIUM)
```
2. Enum class (перечисления)
Используются для ограниченного набора значений:

```kotlin
enum class Difficulty {
    EASY, MEDIUM, HARD
}
```
3. Data class (классы данных)
Автоматически генерируют toString(), equals(), hashCode() и copy():

```kotlin
data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)
```
4. Singleton и Companion object
Обеспечивают существование единственного экземпляра:

```kotlin
class Quiz {
    companion object {
        var total = 10
        var answered = 3
    }
}
// Доступ: Quiz.total, Quiz.answered
```
5. Extension-функции и свойства
Расширяют возможности существующих классов без наследования:

```kotlin
fun String.addExclamation(): String = this + "!"
// "Hello".addExclamation() -> "Hello!"

val Quiz.StudentProgress.progressText: String
    get() = "${answered} of ${total} answered"
```
6. Scope-функции
Позволяют работать с объектом в определённом контексте:

```kotlin
// let - обращение через it
question.let {
    println(it.questionText)
    println(it.answer)
}

// apply - обращение через this, возвращает объект
Quiz().apply {
    printProgressBar()
    printQuiz()
}
```
7. Интерфейсы
Определяют контракт для реализации:

```kotlin
interface ProgressPrintable {
    val progressText: String
    fun printProgressBar()
}

class Quiz : ProgressPrintable {
    override val progressText: String
        get() = "$answered of $total answered"
    
    override fun printProgressBar() {
        repeat(answered) { print("█") }
        repeat(total - answered) { print("░") }
    }
}
```
8. Коллекции
Array (массив)
Фиксированный размер, быстрый доступ по индексу:

```kotlin
val planets = arrayOf("Mercury", "Venus", "Earth", "Mars")
println(planets[0]) // Mercury
planets[1] = "Venus Updated"
```
List (список)
Упорядоченная коллекция, изменяемый размер:

```kotlin
val readOnlyList = listOf("a", "b", "c")
val mutableList = mutableListOf("a", "b", "c")
mutableList.add("d")
mutableList.remove("b")
println(mutableList[0]) // a
```
Set (множество)
Уникальные элементы, быстрый поиск:

```kotlin
val uniqueItems = setOf(1, 2, 3, 3, 3) // [1, 2, 3]
val mutableSet = mutableSetOf(1, 2, 3)
mutableSet.add(4)
mutableSet.remove(2)
println(4 in mutableSet) // true
```
Map (словарь)
Пары "ключ-значение":

```kotlin
val map = mapOf(1 to "one", 2 to "two")
val mutableMap = mutableMapOf(1 to "one", 2 to "two")
mutableMap[3] = "three"
println(mutableMap[1]) // one
mutableMap.remove(2)
```
9. Функции высшего порядка
Функция как параметр:
```kotlin
fun action(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    return operation(a, b)
}
val result = action(5, 3) { x, y -> x + y } // 8
```
Возвращение функции:
```kotlin
fun selectAction(key: Int): (Int, Int) -> Int {
    return when (key) {
        1 -> { a, b -> a + b }
        2 -> { a, b -> a - b }
        else -> { a, b -> a * b }
    }
}
```
10. Функции высшего порядка для коллекций
forEach() - перебор элементов:
```kotlin
cookies.forEach { cookie ->
    println("${cookie.name} - $${cookie.price}")
}
```
map() - преобразование коллекции:
```kotlin
val names = cookies.map { it.name }
val formatted = cookies.map { "${it.name} - $${it.price}" }
```
filter() - фильтрация элементов:
```kotlin
val softCookies = cookies.filter { it.softBaked }
val cheapCookies = cookies.filter { it.price < 1.50 }
```
groupBy() - группировка по ключу:
```kotlin
val grouped = cookies.groupBy { it.softBaked }
val softGroup = grouped[true] ?: emptyList()
```
fold() - свёртка (аккумуляция):
```kotlin
val totalPrice = cookies.fold(0.0) { total, cookie ->
    total + cookie.price
}
```
sortedBy() - сортировка:
```kotlin
val sorted = cookies.sortedBy { it.name }
val byPrice = cookies.sortedByDescending { it.price }
```
