package jetbrains.kotlin.course.alias.card

data class JsCard(
    val id: Int,
    val words: Array<String>
)

fun Card.toJsCard(): JsCard {
    return JsCard(
        id = this.id,
        words = this.words.map { it.word }.toTypedArray()
    )
}


