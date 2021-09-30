package com.je.demo.app.kafka

import com.je.demo.app.avro.TestEvent
import com.je.demo.app.metrics.AppMetrics
import com.je.demo.app.processor.TestEventProcessor
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.springframework.boot.autoconfigure.kafka.ConcurrentKafkaListenerContainerFactoryConfigurer
import org.springframework.boot.autoconfigure.kafka.KafkaProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.config.KafkaListenerContainerFactory
import org.springframework.kafka.listener.ErrorHandler
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.handler.annotation.Header
import org.springframework.messaging.handler.annotation.Payload



@Configuration
class TestEventConsumer(
    private val testEventProcessor: TestEventProcessor,
    private val metrics: AppMetrics
) {

    @KafkaListener(
        containerFactory = testEventContainerFactory,
        topics = [testEventTopic1, testEventTopic2]
    )
    fun consume(
        @Header(KafkaHeaders.RECEIVED_TOPIC) topic: String,
        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) key: String,
        @Payload testEvent: TestEvent
    ) {
        testEventProcessor.process(testEvent)
        metrics.incOkCount(topic)
    }

    @Bean(testEventContainerFactory)
    fun testEventContainerFactory(
        configurer: ConcurrentKafkaListenerContainerFactoryConfigurer,
        kafkaProperties: KafkaProperties,
        errorHandler: ErrorHandler
    ): KafkaListenerContainerFactory<*> {
        val customProperties = HashMap<String, Any>()
        customProperties[ConsumerConfig.CLIENT_ID_CONFIG] = testEventClientId
        customProperties[ConsumerConfig.GROUP_ID_CONFIG] = testEventGroupId
        val consumerFactory = ConsumerConfigUtils.consumerFactory(kafkaProperties, customProperties)
        return ConsumerConfigUtils.kafkaListenerContainerFactory(
            configurer,
            consumerFactory,
            errorHandler
        )
    }
}

