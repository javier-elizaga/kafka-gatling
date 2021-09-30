package com.je.demo.app

import com.je.demo.app.metrics.AppMetrics
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.listener.ErrorHandler
import org.springframework.stereotype.Component

const val unknownTopic = "unknown"

@Component
class ErrorHandlerImpl(private val metrics: AppMetrics) : ErrorHandler {
    override fun handle(ex: Exception, data: ConsumerRecord<*, *>?) {
        metrics.incErrorCount(data?.topic() ?: unknownTopic)
    }
}