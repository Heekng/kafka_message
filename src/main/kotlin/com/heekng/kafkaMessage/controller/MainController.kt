package com.heekng.kafkaMessage.controller

import com.heekng.kafkaMessage.service.KafkaService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MainController(
    private val kafkaService: KafkaService,
) {

    @GetMapping("/inputRecord")
    fun inputRecord(
        record: String,
    ): String {
        kafkaService.addRecord(record)
        return "ok"
    }

}