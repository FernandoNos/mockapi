package config

import akka.parboiled2.RuleTrace.Action
import models.Mock
import org.bson.BsonDouble
import org.mongodb.scala.bson.BsonDocument
import org.mongodb.scala.{Completed, Document, MongoClient, MongoCollection, MongoDatabase, Observable, Observer}
import play.api.libs.json.{JsValue, Json}

import scala.concurrent.Await
import scala.concurrent.duration.Duration

object MongoConnection {

  val mongoConnection = createConnection()

  def createConnection() = {
    val client:MongoClient=MongoClient("mongodb://localhost:27017")
    val database: MongoDatabase = client.getDatabase("mocks")
    database
  }

  def saveNewEntry(entry: JsValue) ={
   val collection = mongoConnection.getCollection("mock")
    val insertObservable: Observable[Completed] = collection.insertOne(Document(entry.toString()))
    insertObservable.subscribe(new Observer[Completed] {
      override def onNext(result: Completed): Unit = println(s"onNext: $result")
      override def onError(e: Throwable): Unit = println(s"onError: $e")
      override def onComplete(): Unit = println("onComplete")
    })
  }

  def getApis() ={
    val collection = mongoConnection.getCollection("mock")
    val mocks = collection.find

    var result : Option[Document] = Option(null)


    Await.result( collection.find().toFuture, Duration.Inf).asInstanceOf[List[Document]]
  }
}
