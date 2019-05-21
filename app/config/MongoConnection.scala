package config

import akka.parboiled2.RuleTrace.Action
import org.mongodb.scala.{Completed, Document, MongoClient, MongoCollection, MongoDatabase, Observable, Observer}

object MongoConnection {

  def createConnection() = {
    val client:MongoClient=MongoClient("mongodb://localhost:27017")
    val database: MongoDatabase = client.getDatabase("mocks")
    val collection: MongoCollection[Document] = database.getCollection("mock")
    val document: Document = Document("test" -> 1, "x" -> 1)
    val insertObservable: Observable[Completed] = collection.insertOne(document)

    insertObservable.subscribe(new Observer[Completed] {
      override def onNext(result: Completed): Unit = println(s"onNext: $result")
      override def onError(e: Throwable): Unit = println(s"onError: $e")
      override def onComplete(): Unit = println("onComplete")
    })

    collection.find().collect().subscribe((results: Seq[Document]) => println(s"Found: #${results.size}"))
  }
}
