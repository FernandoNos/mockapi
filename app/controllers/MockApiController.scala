package controllers

import akka.http.scaladsl.model.HttpHeader.ParsingResult.Ok
import config.MongoConnection
import domain.MockBO
import javax.inject._
import play.api.mvc._

@Singleton
class MockApiController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def createMock(apiPath:String) = Action { implicit request: Request[AnyContent] =>

    val body: AnyContent          = request.body
    var result = MockBO.createMockApi(apiPath, body.asJson)

    Ok(result.toString)
  }
}
