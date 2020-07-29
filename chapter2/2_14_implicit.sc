implicit val context = 1
def printContext(implicit ctx: Int): Unit = {
  println(ctx)
}
printContext

// ここは実行時エラー
// implicit val hoge = 2
// printContext

// Error:(9, 1) ambiguous implicit values:
//  both value context of type Int
//and value hoge of type Int
//match expected type Int
//printContext


// 空のリストについては0を返す
// それ以外のリストについてはリストの和を返す
trait Adder[T] {
  def zero: T

  def plus(x: T, y: T): T
}

// これにより、implicit 宣言された Adder[T] を探す
def sum[T](list: List[T])(implicit adder: Adder[T]): T = {
  list.foldLeft(adder.zero) { (x, y) => adder.plus(x, y) }
}

implicit object IntAdder extends Adder[Int] {
  def zero: Int = 0

  def plus(x: Int, y: Int): Int = x + y
}

implicit object StrAdder extends Adder[String] {
  def zero: String = ""

  def plus(x: String, y: String): String = x + y
}

// これでsumの実装を一般化できる。
// 別のtypeの演算を増やしたい時は Adder[T]を継承した implicit object を増やす
sum(List(1, 2, 3))
sum(List("A","B","C"))