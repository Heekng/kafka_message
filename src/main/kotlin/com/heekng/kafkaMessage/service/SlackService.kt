package com.heekng.kafkaMessage.service

import com.heekng.kafkaMessage.utils.logger
import com.slack.api.Slack
import com.slack.api.methods.SlackApiException
import com.slack.api.methods.request.chat.ChatPostMessageRequest
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class SlackService(
    @Value(value = "\${slack.token}")
    private val token: String,
    @Value(value = "\${slack.channel.monitor}")
    private val channel: String,
    private val log: Logger = logger<SlackService>()
) {

    fun postSlackMessage(message: String) {
        try {
            val methods = Slack.getInstance().methods(token)
            val request = ChatPostMessageRequest.builder()
                .channel(channel)
                .text(message)
                .build()
            methods.chatPostMessage(request)
            log.info("post message success")
        } catch (e: SlackApiException) {
            log.error(e.message)
        }
    }
}