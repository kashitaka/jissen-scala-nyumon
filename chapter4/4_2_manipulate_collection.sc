// ---- Seq の操作 ----
// initialize
Seq("A", "B", "C")
// read
Seq("A", "B", "C")(0)
Seq("A", "B", "C").apply(0)

Seq("A", "B", "C").head // 0番目の要素
Seq("A", "B", "C").last // -1番目の要素

// Option : 要素数のわからない Seq の操作
Seq().headOption // returns None
Seq("A", "B", "C").headOption // returns Some(A)

// 追加・削除
val seq = Seq(1, 2)
10 +: seq // (10,1,2)
seq :+ 10 // (1,2,10)
seq // (1,2)  ※ seq自体は変更されないことの確認

// 結合
val seq2 = Seq(3, 4)
seq ++ seq2 // returns (1, 2, 3, 4)

// 取り出し
Seq(0, 1, 2, 3, 4, 5).take(3) // (0, 1, 2)
Seq(0, 1, 2, 3, 4, 5).takeRight(3) // (3, 4, 5)
// 条件に一致するまで先頭の取り出し
Seq(0, 1, 2, 3, 4, 5).takeWhile(_ < 3) // (0, 1, 2)
Seq(5, 1).takeWhile(_ < 3) // ()

// 捨てる (takeの逆版)
Seq(0, 1, 2, 3, 4, 5).drop(3) // (3, 4, 5)
// 条件に一致するまで先頭を削除
Seq(0, 1, 2, 3, 4, 5).dropRight(3) // (0, 1, 2)
Seq(0, 1, 2, 3, 4, 5).dropWhile(_ < 3) // (3, 4, 5)

// filter
Seq(0, 1, 2, 3, 4, 5, 4, 3, 2, 1).filter(_ < 3)
// sort
Seq(0, 1, 2, 3, 4, 5, 4, 3, 2, 1).sorted
Seq(0, 1, 2, 3, 4, 5, 4, 3, 2, 1).reverse

// この辺のメソッドが用意されてるのは便利

// instance を メンバ変数で sortしたい
case class MyClass(i: Int, j: Int)

Seq(MyClass(3, 1), MyClass(1, 3), MyClass(2, 2)).sortBy(_.i)
Seq(MyClass(3, 1), MyClass(1, 3), MyClass(2, 2)).sortBy(_.j)

// map : seqの要素を変換
Seq("A", "B").map(_ + "さん!") // (Aさん!, Bさん!)

// 畳み込み計算 fold
Seq(1, 2, 3).fold(0)((a, e) =>
  a + e
) // (((0 + 1) + 2 ) + 3)

Seq(1, 2, 3).foldRight(0)((a, e) =>
  a + e
)

// reduceは初期値に0を使わない
Seq(1, 2, 3).reduce((a, e) => a * e)
Seq(1, 2, 3).reduceLeft((a, e) => a * e)

// Seq => Setに変換
Seq(1, 2, 3, 1, 2).toSet // Set(1, 2, 3)
// Seq => Mapに変換　(Seqの要素がタプルじゃないとダメ)
Seq("hello" -> 1, "world" -> 2).toMap


// Mapの具象クラス
Map("e" -> 5, "d" -> 4, "c" -> 3, "b" -> 2, "a" -> 1, "c" -> 33)
// HashMap(e -> 5, a -> 1, b -> 2, c -> 33, d -> 4)
// MapはHashMapを返す。

// TreeMap
import scala.collection.immutable.TreeMap
TreeMap("e" -> 5, "d" -> 4, "c" -> 3, "b" -> 2, "a" -> 1, "c" -> 33)
// TreeMap(a -> 1, b -> 2, c -> 33, d -> 4, e -> 5)
// キーをソートして保持する

// ListMap
import scala.collection.immutable.ListMap
ListMap("e" -> 5, "d" -> 4, "c" -> 3, "b" -> 2, "a" -> 1, "c" -> 33)
// ListMap(e -> 5, d -> 4, c -> 33, b -> 2, a -> 1)
// 要素の挿入順も保持する
