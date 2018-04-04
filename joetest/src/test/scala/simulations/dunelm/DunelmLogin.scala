package simulations.dunelm

import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import io.gatling.http.Predef._
import scala.concurrent.duration._

class DunelmLogin extends Simulation{
  val scn = scenario("DunelmLogin")
    .during(1 minute) {
      exec(http("Login")
        .post("https://qa1.dunelm.com/webapp/wcs/stores/servlet/ESiteLogin") 
        .formParam("storeId", "10151")
        .formParam("catalogId", "10001")
        .formParam("reLogonURL", "RegistrationLogonView")
        .formParam("eSite", "Y")
        .formParam("userType", "G")
        .formParam("longonPrfix", "DUN")
        .formParam("langId", "-1")
        .formParam("fromOrderId", "*")
        .formParam("toOrderId", ".")
        .formParam("continue", "1")
        .formParam("creatIfEmpty", "1")
        .formParam("calculationUsageId", "-1")
        .formParam("updatePrice", "0")
        .formParam("errorViewName", "RegistrationLogonView")
        .formParam("previousPage", "logon")
        .formParam("returnPage", "")
        .formParam("URL", "OrderItemMove?page=&URL=OrderCalculate%3FURL%3DMyAccountDashboardView&calculationUsageId=-1&calculationUsageId=-2&calculationUsageId=-7&deleteCartCookie=true&viewType=orderSummary")
        .formParam("logonId", "ayodeji.joseph@dunelm.com")
        .formParam("logonPassword", "Testing12")
      )
      .pause(5,10)
      .exec(http("Add to basket")
        .post("https://qa1.dunelm.com/webapp/wcs/stores/servlet/ESiteLogin")
        .formParam("storeId", "10151")
        .formParam("langId", "-1")
        .formParam("cataloId", "10002")
        .formParam("quantity", "1")
        .formParam("catEntryId", "359823")
        .formParam("orderId", ".")
        .formParam("calculationUsageId", "-1,-2,-5,-6,-7")
        .formParam("inventryValidation", "true")
        .formParam("errorViewName", "AjaxActionErrorResponse")
        .formParam("miniBasketTotal", "true")
        .formParam("cmCategoryId", "Search")
      )
      .pause(5,10)
      .exec(http("Logout")
        .get("https://qa1.dunelm.com/webapp/wcs/stores/servlet/RegistrationLogonView?catalogId=10001&langId=-1&storeId=10151&ddkey=https%3ALogoff")
      )
    }
  setUp(scn.inject(rampUsers(1) over (1 minutes)))



}
