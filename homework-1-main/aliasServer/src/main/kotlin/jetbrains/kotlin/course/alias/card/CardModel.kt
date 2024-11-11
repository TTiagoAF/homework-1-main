package jetbrains.kotlin.course.alias.card

data class Card(
    val id: Int,
    val words: List<Word>
)

data class Word(
    val word: String,
    val definition: String? = null,
    val synonyms: List<String> = emptyList()
)



