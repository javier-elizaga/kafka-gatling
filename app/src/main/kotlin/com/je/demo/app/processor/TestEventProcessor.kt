package com.je.demo.app.processor

import com.je.demo.app.avro.TestEvent
import com.je.demo.app.metrics.AppMetrics
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class TestEventProcessor() : Processor<TestEvent> {

    private val log = LoggerFactory.getLogger(TestEventProcessor::class.java)

    override fun process(event: TestEvent) {
        Thread.sleep(event.timeToProcess)
        if (event.error) {
            log.error("KO Processing {}", event)
            throw RuntimeException("Random Exception")
        }
        log.info("OK Processing {}", event)
    }

}

