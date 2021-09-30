package simulations

import extensions.kafka.protocol.KafkaProtocol
import io.gatling.core.Predef._
import protocols.Predef
import scenarios.Predef._

import scala.concurrent.duration._
import scala.language.postfixOps

class TestEventSimulation extends Simulation {

  val kafkaConfig: KafkaProtocol = Predef.kafkaProtocol()

  setUp(
    scenarioTestEvent1.inject(constantUsersPerSec(1) during (100 seconds)),
    scenarioTestEvent2.inject(constantUsersPerSec(2) during (50 seconds))
  ).protocols(kafkaConfig)

}

