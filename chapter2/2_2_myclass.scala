// ----- class 宣言 ------
class Point(val x: Int, val y: Int) {

  def distance(that: Point): Int = {
    val xdiff = math.abs(this.x - that.x)
    val ydiff = math.abs(this.y - that.y)
    math.sqrt(xdiff * xdiff + ydiff * ydiff).toInt
  }

  def +(that: Point): Point = {
    new Point(x + that.x, y + that.y)
  }
}

val p1: Point = new Point(10, 10)
val p2: Point = new Point(20, 20)
p1.distance(p2)


// val をつけてないのでvx, vyは変更可能
class Point1(vx: Int, vy: Int) {
  var x = vx
  var y = vy
  vx += vx
}
var p3 = new Point1(10,10)

// フィールドへのアクセス
p3.x
p3.y


// ----- 継承 ------
abstract class Shape {
  def draw(): Unit = {
    println("不明な図形")
  }
}
// abstract classのため newできない
// var hoge: Shape = new Shape
// Class 'Shape' is abstract; cannot be instantiated

class Triangle extends Shape {
  override def draw(): Unit = {
    println("三角形")
  }
}

class Rectangle extends Shape {
  override def draw(): Unit = {
    println("四角形")
  }
}
