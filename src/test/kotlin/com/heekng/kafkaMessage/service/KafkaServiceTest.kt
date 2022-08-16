package com.heekng.kafkaMessage.service

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class KafkaServiceTest @Autowired constructor(
    private val kafkaService: KafkaService,
) {
    @Test
    fun kafkaSendRecordTest() {
        kafkaService.addRecord("hello1")
    }

    @Test
    fun consumer() {
        println(kafkaService.consume())
    }
}