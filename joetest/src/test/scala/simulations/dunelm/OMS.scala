package simulations.dunelm
import scala.concurrent.duration._
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.core.scenario.Simulation

class OMS extends Simulation {
  val scn = scenario("OMS")
    .during(1 minute) {
      exec(http("Access OMS Endpoint")
        .get("https://ordermanager.worldstoresdev.co.uk/isAlive"))
        .pause(5, 10)
    }
  setUp(scn.inject(rampUsers(10) over (1 minutes)))


}

class Promotions extends Simulation {
  val scn = scenario("Promotions")
    .during(1 minute) {
      exec(http("Access Promotions Endpoint")
        .get("https://promotions-service.worldstoresdev.co.uk/isAlive1"))
        .pause(5, 10)
    }
  setUp(scn.inject(rampUsers(10) over (1 minutes)))

}
class StoreLocator extends Simulation {
  val scn = scenario("Store Locator")
    .during(1 minute) {
      exec(http("storeLocator Endpoint")
        .get("http://localhost:3000/stores"))
        .pause(5, 10)
    }
  setUp(scn.inject(rampUsers(12) over (1 minutes)))

}

class StoreLocator_Details extends Simulation {
  val scn = scenario("Store Details")
    .during(1 minute) {
      exec(http("storeLocator Endpoint")
        .get("http://localhost:3000/stores/halifax"))
        .pause(5, 10)
    }
  setUp(scn.inject(rampUsers(12) over (1 minutes)))

}

class Made_To_Measure extends Simulation {
  val scn = scenario("M2M")
    .during(1 minute) {
      exec(http("made to measure")
        .get("http://qa1.dunelm.com/category/home-and-furniture/curtains-and-blinds/made-to-measure/made-to-measure-wood-venetian-blinds-101003--1"))
        .pause(5, 10)
    }
  setUp(scn.inject(rampUsers(12) over (1 minutes)))

}

