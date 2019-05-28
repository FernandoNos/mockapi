package models

import play.api.libs.json.{JsValue, Json}

case class Mock (path: String, requestBody: String)

object Mock{
  implicit val mockJsonFormat = Json.format[Mock]
}
