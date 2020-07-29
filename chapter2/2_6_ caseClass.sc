// ----- case class ------
class Point1(val x: Int, val y: Int)
// コンパイルエラー (Mapのキーになれない)
val map0 = Map(Point1(1,1) -> 1)


case class Point(val x: Int, val y: Int)
// caseをつけることで Mapのキーになる関数が実装される
val map1 = Map(Point(1,1) -> 1)
map1(Point(1,1))

val p = Point(1,2)
// match caseで分解できるようになる
p match {
  case Point(x, y) =>
    println(x); println(y)
}