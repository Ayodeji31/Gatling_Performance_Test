package simulations.dunelm
import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import io.gatling.http.Predef._
import scala.concurrent.duration._

class m2m extends Simulation{

  val m2mHeaders = Map(
    "Accept" -> "application/json, text/javascript, */*; q=0.01",
    "Accept-Encoding" -> "gzip, deflate",
    "Accept-Language" -> "en-US,en;q=0.9,fi;q=0.8",
    "Connection" -> "keep-alive",
    "Content-Type" -> "application/x-www-form-urlencoded; charset=UTF-8",
    "Origin" -> "http://dunv-m2mw1-q2:39851",
    "User-Agent" -> "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36")


  val scn = scenario("BasicSimulation").during(10 minutes){
    //  val scn = scenario("BasicSimulation").during(1 minutes){
    exec(
      exitBlockOnFail {
        //        exec(http("Starting Point")
        //          .get("http://pat.dunelm.com/category/home-and-furniture/curtains-and-blinds/made-to-measure-42003--1")
        //        )
        //        .pause(5)
        //        .exec(http("View Products in Category - Metal Venetian")
        //          .get("http://pat.dunelm.com/category/home-and-furniture/curtains-and-blinds/made-to-measure-42003--1/new-category-47501--1")
        //        )
        //        .pause(5)
        exec(http("View Products in Category - Metal Venetian - M2M")
          //          .get("http://dunv-m2mw1-q2:39851/WebHtmlM2M/shop/m2m/metalvenetian")
          .get("http://m2m.dunelm.com/WebHtmlM2M/shop/m2m/metalvenetian")
        )
          .exec(http("View Products in Category - Metal Venetian - M2M - START Transaction")
            //          .post("http://dunv-m2mw1-q2:39851/WebM2M/shop/metalvenetian/start")
            .post("http://dun-prod-m2m-web01:39851/WebM2M/shop/metalvenetian/start")
            .headers(m2mHeaders)
            //            .formParam("ecommerceConfig", """{"@class":"java.util.HashMap","flag":"Create","configId":"","categoryId":"metalvenetian","userId":"1","orderId":".","customerEmail":"","customerPhone":"","webShopUrl":"http://DUNV-M2MW1-Q2:39852/WebShop/shop","returnURL":"http://DUNV-M2MW1-Q2:39852/WebShop"}""")
            .formParam("ecommerceConfig", """{"@class":"java.util.HashMap","flag":"Create","configId":"","categoryId":"metalvenetian","userId":"1","orderId":".","customerEmail":"","customerPhone":"","webShopUrl":"http://dun-prod-m2m-web01:39852/WebShop/shop","returnURL":"http://dun-prod-m2m-web01:39852/WebShop"}""")
            .formParam("_webVID", "")
            .formParam("_webPID", "")
            .formParam("windowId", "")
            .check(jsonPath("$..viewInstanceId").saveAs("_webVID"))
            .check(jsonPath("$..promptInstanceId").saveAs("_webPID"))
          )
          .exec(session => {
            println(session("_webVID").as[String])
            println(session("_webPID").as[String])
            session
          })
          .pause(5)
          .exec(http("View Product - Metal Venetian - First Product - M2M")
            //          .post("http://dunv-m2mw1-q2:39851/WebM2M/shop/bridge/submitEvent")
            .post("http://dun-prod-m2m-web01:39851/WebM2M/shop/bridge/submitEvent")
            .headers(m2mHeaders)
            .formParam("_webVID", "${_webVID}")
            .formParam("_webPID", "${_webPID}")
            .formParam("windowId", "")
            .formParam("event", """{"@class":"com.enactor.core.web.bridge.WebBridgePageEvent","eventName":"SelectProduct","eventDataJSON":null}""")
            .formParam("data", """{"selectedProductId":"30202141"}""")
            .check(jsonPath("$..viewInstanceId").saveAs("_webVID"))
            .check(jsonPath("$..promptInstanceId").saveAs("_webPID"))
          )
          .exec(http("View Product - Metal Venetian - First Product - M2M - Option")
            //          .post("http://dunv-m2mw1-q2:39851/WebM2M/shop/metalvenetian/option")
            .post("http://dun-prod-m2m-web01:39851/WebM2M/shop/metalvenetian/option")
            .headers(m2mHeaders)
            .formParam("_webVID", "")
            .formParam("_webPID", "")
            .formParam("windowId", "")
            .check(jsonPath("$..viewInstanceId").saveAs("_webVID"))
            .check(jsonPath("$..promptInstanceId").saveAs("_webPID"))
          )
          .pause(5)
          .exec(http("View Product - Metal Venetian - First Product - M2M - Price")
            //          .post("http://dunv-m2mw1-q2:39851/WebM2M/shop/bridge/submitEvent")
            .post("http://dun-prod-m2m-web01:39851/WebM2M/shop/bridge/submitEvent")
            .headers(m2mHeaders)
            .formParam("_webVID", "${_webVID}")
            .formParam("_webPID", "${_webPID}")
            .formParam("windowId", "")
            .formParam("event", """{"@class":"com.enactor.core.web.bridge.WebBridgePageEvent","eventName":"UpdateOptions","eventDataJSON":null}""")
            .formParam("data", """{"MEASUREMENTS:WIDTH::UnitOfMeasure":"LENGTH_METRIC:CENTIMETRE","MEASUREMENTS:WIDTH":"100","MEASUREMENTS:DROP":"100","FITTING_OPTION":"Recess","CONTROL_SIZE":"LiftLeft_TiltRight","m2MConfigData":{"@class":"com.enactor.m2m.configData.M2MMetalVenetianConfigData","m2mConfigGroups":{"@class":"com.enactor.m2m.configData.M2MConfigGroups","fabricGroupKey":{"@class":"com.enactor.core.group.GroupKey","id":"MTL_VENETIAN_FABRIC","groupTypeId":"productGroup","groupHierarchyId":"FABRICS","variantGroupTypeId":"region","variantGroupId":"UK","variantGroupHierarchyId":"All"},"headingGroupKey":{"@class":"com.enactor.core.group.GroupKey","id":"MTL_VENETIAN_HEAD","groupTypeId":"productGroup","groupHierarchyId":"FABRICS","variantGroupTypeId":"region","variantGroupId":"UK","variantGroupHierarchyId":"All"},"searchLozengeGroupIds":["java.util.ArrayList",[""]],"searchLozengeGroupHierarchyIds":["java.util.ArrayList",[""]]},"m2MType":"MetalVenetian","pathTypeM2M":"options","sellJourneyItemsProcessId":"Pos/M2M/MetalVenetian/SellMetalVenetian","priceCalculationProcessId":"Pos/MetalVenetian/LoadMakeUpPrice","priceCalculationProcessDetailId":"PRICE_MTL_VENETIAN","calculatedPrice":0,"drop":63.5,"dropInBaseUnit":400,"width":40,"widthInBaseUnit":400,"initialisedOptions":["java.util.ArrayList",["MEASUREMENTS:WIDTH::UnitOfMeasure","MEASUREMENTS:WIDTH","MEASUREMENTS:DROP::UnitOfMeasure","MEASUREMENTS:DROP","MEASUREMENTS","FITTING_OPTION","CONTROL_SIZE","SLAT_SIZE"]],"ecommerceData":{"@class":"java.util.HashMap","flag":"Create","userId":"1","categoryId":"metalvenetian","customerPhone":"","customerEmail":"","orderId":".","returnURL":"http://pat.dunelm.com:80/AjaxOrderItemDisplayView","configId":""},"optionSetKey":["java.util.ArrayList",[{"@class":"com.enactor.mfc.optionSet.OptionSetKey","keyString":"optionSetId=MTL_VENETIAN_MEASUREMENTS;type=productSetOptionSet;groupTypeId=region;groupId=UK;groupHierarchyId=All;","isDirty":false,"optionSetId":"MTL_VENETIAN_MEASUREMENTS","type":"productSetOptionSet","groupId":{"@class":"com.enactor.core.group.GroupKey","id":"UK","groupTypeId":"region","groupHierarchyId":"All"}},{"@class":"com.enactor.mfc.optionSet.OptionSetKey","keyString":"optionSetId=MTL_VENETIAN_MAIN;type=productSetOptionSet;groupTypeId=region;groupId=UK;groupHierarchyId=All;","isDirty":false,"optionSetId":"MTL_VENETIAN_MAIN","type":"productSetOptionSet","groupId":{"@class":"com.enactor.core.group.GroupKey","id":"UK","groupTypeId":"region","groupHierarchyId":"All"}}]],"fabricProductId":{"@class":"com.enactor.mfc.product.ProductKey","id":"30202141"},"finishedProductId":{"@class":"com.enactor.mfc.product.ProductKey","id":"MTL_25_MM"},"optionCaptureValue":["[Lcom.enactor.mfc.optionCapture.IOptionCaptureData;",[{"@class":"com.enactor.mfc.optionCapture.OptionCaptureData","optionPathId":"MEASUREMENTS","dataType":"UNKNOWN","optionSetId":{"@class":"com.enactor.mfc.optionSet.OptionSetKey","keyString":"","isDirty":false,"optionSetId":"MTL_VENETIAN_MEASUREMENTS","type":"productSetOptionSet","groupId":{"@class":"com.enactor.core.group.GroupKey","id":"UK","groupTypeId":"region","groupHierarchyId":"All"}}},{"@class":"com.enactor.mfc.optionCapture.OptionCaptureData","optionPathId":"MEASUREMENTS:WIDTH","dataType":"UNKNOWN","optionSetId":{"@class":"com.enactor.mfc.optionSet.OptionSetKey","keyString":"","isDirty":false,"optionSetId":"MTL_VENETIAN_MEASUREMENTS","type":"productSetOptionSet","groupId":{"@class":"com.enactor.core.group.GroupKey","id":"UK","groupTypeId":"region","groupHierarchyId":"All"}},"dataValue":"100"},{"@class":"com.enactor.mfc.optionCapture.OptionCaptureData","optionPathId":"MEASUREMENTS:WIDTH::UnitOfMeasure","dataType":"UNKNOWN","optionSetId":{"@class":"com.enactor.mfc.optionSet.OptionSetKey","keyString":"","isDirty":false,"optionSetId":"MTL_VENETIAN_MEASUREMENTS","type":"productSetOptionSet","groupId":{"@class":"com.enactor.core.group.GroupKey","id":"UK","groupTypeId":"region","groupHierarchyId":"All"}},"dataValue":"LENGTH_METRIC:CENTIMETRE"},{"@class":"com.enactor.mfc.optionCapture.OptionCaptureData","optionPathId":"MEASUREMENTS:DROP","dataType":"UNKNOWN","optionSetId":{"@class":"com.enactor.mfc.optionSet.OptionSetKey","keyString":"","isDirty":false,"optionSetId":"MTL_VENETIAN_MEASUREMENTS","type":"productSetOptionSet","groupId":{"@class":"com.enactor.core.group.GroupKey","id":"UK","groupTypeId":"region","groupHierarchyId":"All"}},"dataValue":"100"},{"@class":"com.enactor.mfc.optionCapture.OptionCaptureData","optionPathId":"MEASUREMENTS:DROP::UnitOfMeasure","dataType":"UNKNOWN","optionSetId":{"@class":"com.enactor.mfc.optionSet.OptionSetKey","keyString":"","isDirty":false,"optionSetId":"MTL_VENETIAN_MEASUREMENTS","type":"productSetOptionSet","groupId":{"@class":"com.enactor.core.group.GroupKey","id":"UK","groupTypeId":"region","groupHierarchyId":"All"}},"dataValue":"LENGTH_METRIC:CENTIMETRE"},{"@class":"com.enactor.mfc.optionCapture.OptionCaptureData","optionPathId":"FITTING_OPTION","dataType":"UNKNOWN","optionSetId":{"@class":"com.enactor.mfc.optionSet.OptionSetKey","keyString":"","isDirty":false,"optionSetId":"MTL_VENETIAN_MAIN","type":"productSetOptionSet","groupId":{"@class":"com.enactor.core.group.GroupKey","id":"UK","groupTypeId":"region","groupHierarchyId":"All"}},"dataValue":"Recess"},{"@class":"com.enactor.mfc.optionCapture.OptionCaptureData","optionPathId":"CONTROL_SIZE","dataType":"UNKNOWN","optionSetId":{"@class":"com.enactor.mfc.optionSet.OptionSetKey","keyString":"","isDirty":false,"optionSetId":"MTL_VENETIAN_MAIN","type":"productSetOptionSet","groupId":{"@class":"com.enactor.core.group.GroupKey","id":"UK","groupTypeId":"region","groupHierarchyId":"All"}},"dataValue":"LiftLeft_TiltRight"},{"@class":"com.enactor.mfc.optionCapture.OptionCaptureData","optionPathId":"SLAT_SIZE","dataType":"UNKNOWN","optionSetId":{"@class":"com.enactor.mfc.optionSet.OptionSetKey","keyString":"","isDirty":false,"optionSetId":"MTL_VENETIAN_MAIN","type":"productSetOptionSet","groupId":{"@class":"com.enactor.core.group.GroupKey","id":"UK","groupTypeId":"region","groupHierarchyId":"All"}},"dataValue":"30202270"}]]},"skipValidation":false}""")
            .check(jsonPath("$").saveAs("priceResponse"))
          )
          .exec(session => {
            //            println(session("priceResponse").as[String])
            session
          })
      })}
  //  setUp(scn.inject(atOnceUsers(1)))
  setUp(scn.inject(rampUsers(25) over(1 minutes)))
}
