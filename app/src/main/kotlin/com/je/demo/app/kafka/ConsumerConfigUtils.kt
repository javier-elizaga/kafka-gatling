package com.je.demo.app.kafka

import org.springframework.boot.autoconfigure.kafka.ConcurrentKafkaListenerContainerFactoryConfigurer
import org.springframework.boot.autoconfigure.kafka.KafkaProperties
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.config.KafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.listener.ErrorHandler

object ConsumerConfigUtils {

    fun kafkaListenerContainerFactory(
        configurer: ConcurrentKafkaListenerContainerFactoryConfigurer,
        consumerFactory: ConsumerFactory<Any, Any>,
        errorHandler: ErrorHandler
    ): KafkaListenerContainerFactory<*> {
        val factory = ConcurrentKafkaListenerContainerFactory<Any, Any>()
        configurer.configure(factory, consumerFactory)
        factory.setErrorHandler(errorHandler)
        return factory
    }

    fun consumerFactory(
        kafkaProperties: KafkaProperties,
        customProperties: Map<String, Any>
    ): ConsumerFactory<Any, Any> {
        val consumerConfig = consumerConfig(kafkaProperties, customProperties)
        return DefaultKafkaConsumerFactory(consumerConfig)
    }

    private fun consumerConfig(
        properties: KafkaProperties,
        customProperties: Map<String, Any>
    ): Map<String, Any> {
        val configs = HashMap<String, Any>()
        // use common spring kafka consumer properties. ie: deserializers, polling strategies, ...
        configs.putAll(properties.buildConsumerProperties())
        // Add specific properties for consumer
        configs.putAll(customProperties)
        return configs
    }
}

