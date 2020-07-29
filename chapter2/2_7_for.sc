// ---- for ----
// ジェネレーター (変数名 <- 式) で定義される
for (x <- 1 to 3; y <- 1 until 3) {
  println("x = " + x + ", y = " + y)
}
//x = 1, y = 1
//x = 1, y = 2
//x = 2, y = 1
//x = 2, y = 2
//x = 3, y = 1
//x = 3, y = 2

for (e <- List(1, 2, 3)) println(e)
//1
//2
//3

// yield をつけると戻り値として、要素の捜査結果が帰るようになる
for (e <- List(1, 2, 3)) yield {
  e + 1
}
// val res2: List[Int] = List(2, 3, 4)
// 下記のように変数にも入れられる
val hoge: List[Int] = for (e <- List(1, 2, 3)) yield {
  e + 1
}

// パターンmatch
var i: Int = 5
i match {
  case 0 => "A"
  case 1 => "B"
  case _ => "?"
}

// x :: xsは (x, xs) と同じ
def reverse[A](list: List[A], result: List[A]): List[A] = list match {
  case x :: xs => reverse(xs, x :: result)

  case Nil => result
}
reverse(List(1, 2, 3), Nil)

// ---- exception ----
def divide(x: Int, y: Int): Int = {
  if (y == 0) throw new RuntimeException("0で割るな")
  x / y
}
// 下記は実行エラー
// divide(10, 0)
// 下記はtry catch
try {
  divide(10, 0)
} catch {
  case e: RuntimeException => println(e.getMessage)
}

// ---- アクセス修飾子 -----
// private
class Printer(x:Int){
  private def print(): Unit = println(x)
}
//(new Printer(1)).print()


// protected : 小クラス内で呼べる
class Super {
  protected def puts(message: String): Unit = {
    println(message)
  }
}
class Sun extends Super {
  def sub(): Unit = {
    puts("sub()")
  }
}

// ---- lazy 修飾子 ----
// instance生成の度に計算させたくないもので有効
// 呼び出した際に初めて計算される
class Circle(radius: Int) {
  lazy val area: Double = {
    radius * radius * math.Pi
  }
}
val circle1 = new Circle(10)
println(circle1.area)  // ここで初めてareaを評価


// ---- final -----
// subclassでoverrideできない
class Super {
  final def foo: Unit = println("Foo")
}

// ---- abstract -----
// fooは中身なし。barのように実装もできる。
abstract class Super {
  def foo: Unit
  def bar: Unit = {
    println("hoge")
  }
}
// subclassでは fooを実装しないとコンパイルエラー
class SubClass extends Super {
  override def foo: Unit = {
    println("foo")
  }
  override def bar: Unit = {
    println("SubHoge")
  }
}
