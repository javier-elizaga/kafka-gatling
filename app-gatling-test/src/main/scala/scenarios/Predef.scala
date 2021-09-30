package scenarios

import com.je.demo.app.avro.TestEvent
import extensions.kafka.Predef._
import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder

import java.util.UUID
import scala.collection.mutable
import scala.language.postfixOps

object Predef {

  private val tpcTestEvent1 = "test-event-topic-1"
  private val scnTestEvent1 = s"${tpcTestEvent1}__SCN"
  private val reqTestEvent1 = s"${tpcTestEvent1}__REQ"

  private val tpcTestEvent2 = "test-event-topic-2"
  private val scnTestEvent2 = s"${tpcTestEvent2}__SCN"
  private val reqTestEvent2 = s"${tpcTestEvent2}__REQ"


  val scenarioTestEvent1: ScenarioBuilder = generateScenario(scnTestEvent1, reqTestEvent1, tpcTestEvent1)
  val scenarioTestEvent2: ScenarioBuilder = generateScenario(scnTestEvent2, reqTestEvent2, tpcTestEvent2)

  private val errorCounter: mutable.Map[String, Int] = mutable.HashMap()
  private var totalEventCounter = 1
  private val errorEvery = 10
  private val timeToProcess = 100L

  private def generateScenario(scnName: String, reqName: String, topic: String): ScenarioBuilder = {
    scenario(scnName)
      .feed(Iterator.continually(getRecord(topic)))
      .exec(
        kafka(reqName).send[String, TestEvent](topic, "${key}", "${event}")
      )
  }

  // The event drives how is consumed.
  private def getRecord(topic: String): Map[String, Object] = {
    val username = UUID.randomUUID().toString
    val count: Int = errorCounter.getOrElse(topic, 1)
    val error = count % errorEvery == 0
    errorCounter.put(topic, count + 1)
    totalEventCounter += 1
    Map("key" -> username, "event" -> new TestEvent(username, totalEventCounter, timeToProcess, error, topic))
  }

}

