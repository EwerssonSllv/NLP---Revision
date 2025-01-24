package com.ewersson.nlp.service

import opennlp.tools.sentdetect.SentenceDetectorME
import opennlp.tools.sentdetect.SentenceModel
import opennlp.tools.stemmer.PorterStemmer
import opennlp.tools.tokenize.SimpleTokenizer
import org.springframework.stereotype.Service


@Service
class NLPService {

    fun tokenizeText(text: String?): Array<String> {
        val tokenizer = SimpleTokenizer.INSTANCE
        return tokenizer.tokenize(text)
    }

    @Throws(Exception::class)
    fun detectSentences(text: String?): Array<String> {
        javaClass.getResourceAsStream("/models/opennlp-pt-ud-gsd-sentence-1.2-2.5.0.bin").use { modelStream ->
            val model = SentenceModel(modelStream)
            val detector = SentenceDetectorME(model)
            return detector.sentDetect(text)
        }
    }


    fun stemWord(word: String?): String {
        val stemmer = PorterStemmer()
        return stemmer.stem(word)
    }
}
