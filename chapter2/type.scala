
// ---- tuple 型について ----
val tuple1: (Int, String) = (30, "Hoge")

val tuple2: (Int, Int, Int) = (30, 40, 50)

println(tuple1)
// 1番目の要素
println(tuple1._1)

println(tuple2)

// matchを使ったtupleの分解
tuple2 match {
  case (x,y,z) =>
    println(x)
    println(y)
    println(z)
}