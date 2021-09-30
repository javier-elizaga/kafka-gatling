package com.je.demo.app.metrics

import io.prometheus.client.CollectorRegistry
import io.prometheus.client.Counter
import org.springframework.stereotype.Component

const val topicLabel = "topic"

@Component
class AppMetrics(private val collectorRegistry: CollectorRegistry) {

    private val namespace = "app"

    private val okCount: Counter =
        counter("EventOK", "received user info events", topicLabel)

    private val koCount: Counter =
        counter("EventKO", "errors processing events", topicLabel)

    fun incOkCount(topic: String, amount: Double = 1.0) = okCount.labels(topic).inc(amount)

    fun incErrorCount(topic: String, amount: Double = 1.0) = koCount.labels(topic).inc(amount)

    private fun counter(name: String, help: String, vararg labelNames: String): Counter {
        return Counter.build()
            .name(name)
            .namespace(namespace)
            .help(help)
            .labelNames(*labelNames)
            .create()
            .register(collectorRegistry)

    }

}