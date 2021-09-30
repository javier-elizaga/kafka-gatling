package protocols

import extensions.kafka.Predef._
import extensions.kafka.protocol.KafkaProtocol
import io.confluent.kafka.serializers.KafkaAvroSerializer
import io.gatling.core.Predef._
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer

import scala.language.postfixOps

object Predef {

  def kafkaProtocol(): KafkaProtocol = {
    kafka
      .properties(Map(
        ProducerConfig.ACKS_CONFIG -> "1",
        ProducerConfig.BOOTSTRAP_SERVERS_CONFIG -> "localhost:29092",
        ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG -> classOf[StringSerializer],
        ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG -> classOf[KafkaAvroSerializer],
        "schema.registry.url" -> "http://localhost:8085"
      ))
  }
}
