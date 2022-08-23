package com.heekng.kafkaMessage.controller

import com.heekng.kafkaMessage.service.KafkaService
import com.heekng.kafkaMessage.utils.logger
import org.slf4j.Logger
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class MainController(
    private val kafkaService: KafkaService,
    private val log: Logger = logger<MainController>()
) {

    @GetMapping("/sendMessage")
    fun inputRecord(
        @RequestParam message: String,
    ): String {
        log.info("controller message={}", message)
        kafkaService.addRecord(message)
        return "ok"
    }

}