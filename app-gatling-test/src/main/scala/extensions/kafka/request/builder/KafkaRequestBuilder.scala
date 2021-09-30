package extensions.kafka.request.builder

import extensions.kafka.action.KafkaRequestActionBuilder
import io.gatling.core.session._

case class KafkaAttributes[K, V](requestName: Expression[String], topic: Option[String], key: Option[Expression[K]], payload: Expression[V])

case class KafkaRequestBuilder(requestName: Expression[String]) {

  def send[K, V](payload: Expression[V]): KafkaRequestActionBuilder[K, V] = send(None, None, payload)

  def send[K, V](key: Expression[K], payload: Expression[V]): KafkaRequestActionBuilder[K, V] = send(None, Some(key), payload)

  private def send[K, V](topic: Option[String], key: Option[Expression[K]], payload: Expression[V]) = new KafkaRequestActionBuilder(KafkaAttributes(requestName, topic, key, payload))

  def send[K, V](topic: String, key: Expression[K], payload: Expression[V]): KafkaRequestActionBuilder[K, V] = send(Some(topic), Some(key), payload)

}