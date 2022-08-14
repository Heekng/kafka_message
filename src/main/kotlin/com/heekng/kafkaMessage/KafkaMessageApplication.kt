package com.heekng.kafkaMessage

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KafkaMessageApplication

fun main(args: Array<String>) {
	runApplication<KafkaMessageApplication>(*args)
}
