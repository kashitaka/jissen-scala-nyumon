import scala.util.Try

Try

def div(a:Int, b:Int): Try[Int] = Try(a/b)

div(10,0) // Failure(java.lang.ArithmeticException: / by zero)
div(10,1) // Success(10)

// Eitherの突起と同様、foreachを使えばSuccessの値だけを拾える
div(10,1).foreach(println)

// Eitherのleft関数は, Tryでは failed 関数になる
div(10,0).failed.foreach(println)

div(10,3)

// getOrElseも使える
div(10,0).getOrElse(-1)
