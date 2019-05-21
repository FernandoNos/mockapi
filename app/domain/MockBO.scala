package domain

import config.MongoConnection
import play.api.libs.json.JsValue
import utils.MockPathTrait


object MockBO extends MockPathTrait {

  def createMockApi(apiPath : String, body : Option[JsValue]) ={
    val bodyValue : JsValue = body.get
    MongoConnection.createConnection()
    val mockBody  = ("path" -> apiPath,
                      "requestBody" -> bodyValue)
    val x = 0

  }

}
