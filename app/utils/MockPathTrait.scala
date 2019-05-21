package utils

import scala.util.matching.Regex

trait MockPathTrait {

  def isCreate(path : String) {
    val pattern : Regex = "/create/(.*)".r
    pattern.findFirstIn(path)
  }

}
