import scala.concurrent.{ExecutionContext, Future}
import scala.io.{BufferedSource, Source}
import scala.util.{Failure, Success}
import scala.concurrent.ExecutionContext.Implicits.global // <- これが大事！
// Future


// ここは同期関数
object HttpTextClient {
  def get(url: String): BufferedSource = Source.fromURL(url)
}

// Future内で 同期関数を呼び出し
val res = Future(HttpTextClient.get("https://www.google.com"))
res.onComplete {
  case Success(body) =>
    println(body.mkString)
  case Failure(throwable) =>
    println("エラー発生", throwable.toString)
}