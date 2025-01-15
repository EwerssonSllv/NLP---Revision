package com.ewersson.npl.controller

import com.ewersson.npl.service.NLPService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/nlp")
class NLPController {
    @Autowired
    private val nlpService: NLPService? = null

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
