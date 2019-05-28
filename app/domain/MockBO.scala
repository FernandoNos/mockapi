package domain

import config.MongoConnection
import play.api.libs.json.{JsValue, Json}
import utils.MockPathTrait


object MockBO extends MockPathTrait {

  def createMockApi(apiPath : String, body : Option[JsValue]) ={
    val bodyValue : JsValue = body.get
    val mockBody  = ("path" -> apiPath,
                      "requestBody" -> bodyValue)
    val root = play.libs.Json.newObject()
    root.put("path",apiPath)
    root.put("requestBody", bodyValue.toString())
    MongoConnection.saveNewEntry(Json.parse(root.toString))
    MongoConnection.getApis()

  }

}
