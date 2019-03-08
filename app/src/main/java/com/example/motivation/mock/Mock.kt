package com.example.motivation.mock

import com.example.motivation.contants.MotivationConstants
import java.util.*

class Phrase(val description: String, val category: Int)

fun Int.random(): Int = Random().nextInt(this)

private val ALL = MotivationConstants.PRHASE_FILTER.ALL
private val HAPPY = MotivationConstants.PRHASE_FILTER.HAPPY
private val SUN = MotivationConstants.PRHASE_FILTER.SUN

class Mock {
    private val mListPhrases: List<Phrase> = listOf(
            Phrase("Não sabendo que era impossível, foi lá e fez.", HAPPY),
            Phrase("Você nao é derrotado quando perde, você é derrotado quando desiste!", HAPPY),
            Phrase("Se você acredita, faz com toda diferença", SUN),
            Phrase("A melhor maneira de prever o futuro é inventá-lo!", SUN)
    )

    fun getPrhase(value: Int): String {
        val filtered = mListPhrases.filter { (it.category == value || value == ALL) }

        val rand = (filtered.size).random()

        return filtered[rand].description

    }
}