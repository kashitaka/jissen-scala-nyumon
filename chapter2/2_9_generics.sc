// ----- ジェネリクスの記法 -----
class Cell[A](var value: A){
  def put(newValue: A): Unit = {
    value = newValue
  }

  def get: A = value
}

// このクラスの使い方
val strCell = new Cell[String]("Hello")
