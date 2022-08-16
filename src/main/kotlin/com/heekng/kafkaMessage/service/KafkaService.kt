package com.heekng.kafkaMessage.service

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class KafkaService(
    private val kafkaTemplate: KafkaTemplate<String, String>,
) {

    fun addRecord(recordText: String) {
        kafkaTemplate.send("heekng_topic", recordText)
    }

    @KafkaListener(topics = ["heekng_topic"], groupId = "heekng")
    fun consume(message: String? = null) {
        println(message)
    }


}