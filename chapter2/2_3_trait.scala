import scala.collection.mutable.Buffer

// ----- トレイト（特性） -----
// 例：Nameable 名前がつけられるという特性
// javaのInterfaceと違って関数に実装をもつ
trait Nameable {
  val name: String
  def display(): Unit = println(name)
}

// 従業員にNamaebleを付与
class Employee(val name: String) extends AnyRef with Nameable {

}

val taro = new Employee("taro")
taro.display()

trait Enumerable[A] {
  def foreach[B](fun: A => B): Unit
}

class Shop(val name: String) extends AnyRef with Enumerable with Nameable {

}

// コンパイルエラーでびるどできない