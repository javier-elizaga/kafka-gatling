package extensions.kafka.action

import extensions.kafka.protocol.KafkaProtocol
import extensions.kafka.request.builder.KafkaAttributes
import io.gatling.core.action.{Action, ExitableAction}
import io.gatling.commons.stats.{KO, OK}
import io.gatling.core.session._
import io.gatling.commons.util.DefaultClock
import io.gatling.commons.validation.Validation
import io.gatling.core.CoreComponents
import io.gatling.core.stats.StatsEngine
import io.gatling.core.util.NameGen
import org.apache.kafka.clients.producer._

class KafkaRequestAction[K, V](val producer: KafkaProducer[K, V],
                               val kafkaAttributes: KafkaAttributes[K, V],
                               val coreComponents: CoreComponents,
                               val kafkaProtocol: KafkaProtocol,
                               val throttled: Boolean,
                               val next: Action)
  extends ExitableAction with NameGen {

  override val name: String = genName("kafkaRequest")
  val statsEngine: StatsEngine = coreComponents.statsEngine
  val clock = new DefaultClock

  override def execute(session: Session): Unit = recover(session) {

    kafkaAttributes.requestName(session).flatMap { requestName =>

      val outcome =
        sendRequest(
          requestName,
          producer,
          kafkaAttributes,
          throttled,
          session)

      outcome.onFailure(
        errorMessage =>
          statsEngine.reportUnbuildableRequest(session.scenario, session.groups, requestName, errorMessage)
      )

      outcome

    }

  }

  private def sendRequest(requestName: String,
                          producer: Producer[K, V],
                          kafkaAttributes: KafkaAttributes[K, V],
                          throttled: Boolean,
                          session: Session): Validation[Unit] = {

    kafkaAttributes payload session map { payload =>

      val record = kafkaAttributes.key match {
        case Some(k) =>
          new ProducerRecord[K, V](kafkaAttributes.topic.getOrElse(kafkaProtocol.topic), k(session).toOption.get, payload)
        case None =>
          new ProducerRecord[K, V](kafkaProtocol.topic, payload)
      }

      val requestStartDate = clock.nowMillis

      producer.send(record, new Callback() {

        override def onCompletion(m: RecordMetadata, e: Exception): Unit = {

          val requestEndDate = clock.nowMillis
          statsEngine.logResponse(
            session.scenario,
            session.groups,
            requestName,
            startTimestamp = requestStartDate,
            endTimestamp = requestEndDate,
            if (e == null) OK else KO,
            None,
            if (e == null) None else Some(e.getMessage)
          )

          if (throttled) {
            coreComponents.throttler.foreach(_.throttle(session.scenario, () => next ! session))
          } else {
            next ! session
          }

        }
      })

    }

  }

}