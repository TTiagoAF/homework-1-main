package jetbrains.kotlin.course.alias.card

import org.springframework.stereotype.Service

import jetbrains.kotlin.course.alias.util.IdentifierFactory
import jetbrains.kotlin.course.alias.util.Identifier
import jetbrains.kotlin.course.alias.util.words

@Service
class CardService {

    private val identifierFactory: IdentifierFactory = IdentifierFactory()

    private val cards: List<Card> = generateCards()

    private fun generateCards(): List<Card> {
        val shuffledWords = words.shuffled()
        return shuffledWords.chunked(WORDS_IN_CARD).take(cardsAmount).map { chunk ->
            Card(id = identifierFactory.uniqueIdentifier(), words = chunk.toWords())
        }
    }

    private fun List<String>.toWords(): List<Word> = this.map { Word(it) }

    fun getCardByIndex(index: Int): Card = cards.getOrElse(index) {
        throw IndexOutOfBoundsException("Card at index $index does not exist.")
    }

    companion object {
        private val WORDS_IN_CARD = 4
        val cardsAmount: Int = words.size / WORDS_IN_CARD
    }
}
