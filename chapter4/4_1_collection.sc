

// Seq 一列に順番に並んでる
val seq = Seq("A", "B", "C")
seq(1)

// Set 重複した要素を含まない集合
val set = Set("A", "A", "B", "C")
set.contains("D")

// Map KeyとValueの集合(set)
val map = Map("A" -> 10, "A" -> 100, "C" -> 20, "B" -> 30)
map("A")

// Seq, Set, Mapはimmutable
// seq(0) = "C" コンパイルエラー

// これらはscalaの built-in クラスで
// mutableなCollection mutableからパッケージをimportすれば使える
val mutableSeq = scala.collection.mutable.Seq(1, 2, 3)
mutableSeq(0) = 10
mutableSeq // ArrayBuffer(10, 2, 3)