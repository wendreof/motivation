package com.example.motivation.mock

import com.example.motivation.contants.MotivationConstants

class Phrase(description: String, category: Int)

private val ALL = MotivationConstants.PRHASE_FILTER.ALL
private val HAPPY = MotivationConstants.PRHASE_FILTER.HAPPY
private val SUN = MotivationConstants.PRHASE_FILTER.SUN

class Mock {
    private val mListPhrases: List<Phrase> = listOf(
            Phrase("Não sabendo que era impossível, foi lá e fez.", ALL),
            Phrase("Você nao é derrotado quando perde, você é derrotado quando desiste!", ALL)
    )
}