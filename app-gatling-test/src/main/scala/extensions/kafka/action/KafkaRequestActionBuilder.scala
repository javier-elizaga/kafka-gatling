package extensions.kafka.action

import extensions.kafka.protocol.{KafkaComponents, KafkaProtocol}
import extensions.kafka.request.builder.KafkaAttributes
import io.gatling.core.action.Action
import io.gatling.core.action.builder.ActionBuilder
import io.gatling.core.structure.ScenarioContext
import org.apache.kafka.clients.producer.KafkaProducer

// scala 2.12 import scala.collection.JavaConverters._
import scala.jdk.CollectionConverters._

class KafkaRequestActionBuilder[K,V](kafkaAttributes: KafkaAttributes[K,V]) extends ActionBuilder {

  override def build( ctx: ScenarioContext, next: Action ): Action = {
    import ctx.{coreComponents, protocolComponentsRegistry, throttled}

    val kafkaComponents: KafkaComponents = protocolComponentsRegistry.components(KafkaProtocol.KafkaProtocolKey)

    val producer = new KafkaProducer[K,V]( kafkaComponents.kafkaProtocol.properties.asJava )

    coreComponents.actorSystem.registerOnTermination(producer.close())

    new KafkaRequestAction(
      producer,
      kafkaAttributes,
      coreComponents,
      kafkaComponents.kafkaProtocol,
      throttled,
      next
    )
  }
}