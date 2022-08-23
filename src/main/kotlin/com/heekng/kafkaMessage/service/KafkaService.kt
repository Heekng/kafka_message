package com.heekng.kafkaMessage.service

import com.heekng.kafkaMessage.utils.logger
import org.slf4j.Logger
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class KafkaService(
    private val kafkaTemplate: KafkaTemplate<String, String>,
    private val slackService: SlackService,
    private val log: Logger = logger<KafkaService>()
) {

    fun addRecord(recordText: String) {
        kafkaTemplate.send("heekng_topic", recordText)
    }

    @KafkaListener(topics = ["heekng_topic"], groupId = "heekng")
    fun consume(message: String) {
        log.info("input message -> {}", message)
        slackService.postSlackMessage(message)
    }

}