package com.ewersson.nlp.controller

import com.ewersson.nlp.service.NLPService
import com.ewersson.nlp.service.QueryProcessor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/nlp")
class NLPController(
    private val queryProcessor: QueryProcessor
) {
    @Autowired
    private val nlpService: NLPService? = null


    @PostMapping("/query")
    fun processQuery(@RequestBody query: String): Map<String, String> {
        val response = queryProcessor.processQuery(query)
        return mapOf("response" to response)
    }


    @PostMapping("/tokenize")
    fun tokenizeText(@RequestBody text: String?): Array<String> {
        return nlpService!!.tokenizeText(text)
    }


    @PostMapping("/sentences")
    @Throws(Exception::class)
    fun detectSentences(@RequestBody text: String?): Array<String> {
        return nlpService!!.detectSentences(text)
    }

    @PostMapping("/stem")
    fun stemWord(@RequestBody word: String?): String {
        return nlpService!!.stemWord(word)
    }
}
