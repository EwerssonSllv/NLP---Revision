package com.ewersson.npl

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class NplApplication

fun main(args: Array<String>) {
	runApplication<NplApplication>(*args)
}
