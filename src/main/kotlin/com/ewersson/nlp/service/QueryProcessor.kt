package com.ewersson.nlp.service

import com.ewersson.nlp.enums.QueryType
import org.springframework.stereotype.Service

@Service
class QueryProcessor {

    fun processQuery(query: String): String {
        val queryType = determineQueryType(query)

        return when (queryType) {
            QueryType.HOJE -> handleHojeQuery(query)
            QueryType.ONTEM -> handleOntemQuery(query)
            QueryType.SP -> handleSPQuery(query)
            QueryType.PERGUNTA -> "A mensagem parece ser uma pergunta: $query"
            QueryType.DESCONHECIDO -> "Não entendi sua consulta."
        }
    }

    private fun determineQueryType(query: String): QueryType {
        return when {
            query.contains("hoje", ignoreCase = true) -> QueryType.HOJE
            query.contains("ontem", ignoreCase = true) -> QueryType.ONTEM
            query.contains("SP", ignoreCase = true) -> QueryType.SP
            query.contains("?", ignoreCase = true) -> QueryType.PERGUNTA
            else -> QueryType.DESCONHECIDO
        }
    }

    private fun handleHojeQuery(query: String): String {
        return if (query.contains("tempo", ignoreCase = true)) {
            "A mensagem se refere à previsão do tempo para hoje"
        } else {
            "A mensagem se refere a data atual"
        }
    }

    private fun handleOntemQuery(query: String): String {
        return if (query.contains("aconteceu", ignoreCase = true)) {
            "A mensagem se refere a um evento que ocorreu ontem"
        } else {
            "A mensagem se refere ao dia anterior a esse"
        }
    }

    private fun handleSPQuery(query: String): String {
        return if (query.contains("capital", ignoreCase = true)) {
            "A mensagem se refere à cidade de São Paulo, capital do estado"
        } else {
            "A mensagem se refere ao estado de São Paulo"
        }
    }
}
