// ------ apply -------
// applyは特殊なメソッド。
// value(x)という記述をした際に applyが呼ばれる
object Add {
  def apply(x: Int, y: Int): Int = x + y
}

// 下記は同義
Add.apply(1, 2)
Add(1, 2)


// ------ unary_ -------
// +, -, !, ~の演算子を定義できる
// +hoge, !fuga などが使えるようになる
class MyString(val content: String) {
  def unary_! : String = "!" + content
}

val hoge: MyString = new MyString("hogehoge")
!hoge  // returns "!hogehoge"

