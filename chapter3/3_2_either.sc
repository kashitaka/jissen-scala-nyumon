import java.io.File
// ----- Either -----
// Optionの中身がNoneだった場合の処理を記述できる

// 下記の関数は StringまたはLongを返す。
// 慣例的に左が異常系、右が正常系（なんか違和感ある）
def fileSize(file: File): Either[String, Long] =
  if (file.exists())
    Right(file.length()) else Left("File not exists")

// Either + foreach
// Rightのときのみ関数を実行する
val r: Either[String, Int] = Right(100)
val l: Either[String, Int] = Left("aaaaa")
r.foreach(println) // 100
l.foreach(println) // 何も出ない

//leftの時だけ出力したい場合はleftをEither型に使う
r.left.foreach(println) // 何も出ない
l.left.foreach(println) // "aaaaa"

// これはなんかややこしいなあ...
// 読んでて訳わかんなくね？
val either: Either[String, Long] = Right(10L)
either.map(_ * 2) // Right(20)
either.right.map(_ * 2) // Right(20) deprecatedだから使うな
either.left.map(_ + "1") // Rightなので処理されない

Right(1).getOrElse(100) // 1が返る
Left(1).getOrElse(100) // LeftなのでgetOrElseの中身の100が返る

// mergeを使えばRightかLeftかわからんが値が取り出せる
either.merge