package extensions.kafka.protocol

import io.gatling.core.CoreComponents
import io.gatling.core.config.GatlingConfiguration
import io.gatling.core.protocol.{Protocol, ProtocolKey}

object KafkaProtocol {

  val KafkaProtocolKey: ProtocolKey[KafkaProtocol, KafkaComponents] {
    type Protocol = KafkaProtocol

    type Components = KafkaComponents
  } = new ProtocolKey[KafkaProtocol, KafkaComponents] {

    type Protocol = KafkaProtocol
    type Components = KafkaComponents

    def protocolClass: Class[io.gatling.core.protocol.Protocol] = classOf[KafkaProtocol].asInstanceOf[Class[io.gatling.core.protocol.Protocol]]

    def defaultProtocolValue(configuration: GatlingConfiguration): KafkaProtocol = KafkaProtocol(configuration)

    def newComponents(coreComponents: CoreComponents): KafkaProtocol => KafkaComponents = {
      kafkaProtocol => {
        val kafkaComponents = KafkaComponents(
          kafkaProtocol
        )

        kafkaComponents
      }
    }
  }

  def apply(configuration: GatlingConfiguration): KafkaProtocol = KafkaProtocol(
    topic = "",
    properties = Map()
  )
}

case class KafkaProtocol(topic: String, properties: Map[String, Object]) extends Protocol {
  def topic(topic: String): KafkaProtocol = copy(topic = topic)
  def properties(properties: Map[String, Object]): KafkaProtocol = copy(properties = properties)
}

