package org.example.reactiveloadtest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ReactiveLoadTestApplication

fun main(args: Array<String>) {
    runApplication<ReactiveLoadTestApplication>(*args)
}
