// nullは使わない
// 代わりに Option を使う
// Javaと違って実行時のNullPointerExceptionが起きない

import java.io.File

val directory = new File("no such directory or file")
// 下記は実行時エラーjava.lang.NullPointerException
// directory.listFiles().length


// Scala では Option を使う
// 下記の関数は戻り値がOption型
def myListFiles(directory: File): Option[Array[File]] = {
  // Optionを作る
  Option(directory.listFiles())
}

var files: Option[Array[File]] = myListFiles(directory)

// Option型になかみのmethodは呼び出せない
// files.length

// Option作るには
Option("なんらかのObject") //Some(なんらかのObject)
Option(null) // Option[Null] = None


// mapを使うとOptionの中身を操作できる。
// Noneの場合は結果もNoneになるので、ぬるぽが出ない
Option(123L).map(_.toString)
None.map(_.toString)

// Option同士の演算でOptionを返す。flatmapが有効
def plus(option1: Option[Int],
         option2: Option[Int]): Option[Int] = {
  option1.flatMap(i => option2.map(j => i + j))
  // option1.map(i => option2.map(j => i + j))
  // の場合は Option[Option[Int]]が返る。
}
plus(Option(1), Option(2)) //Option[Int] = Some(3)
plus(Option(2), None)  // InputにNoneがあればNoneが返る

// 上記の plus() を for で書き直すと
def plusFor(option1: Option[Int],
         option2: Option[Int]): Option[Int] = {
  // yieldは、通常forがUnitを返すところを、
  // ループの中身の評価を返す
  for (i <- option1; j <- option2) yield i + j
}

plusFor(Option(1), Option(2))

// ----- Optionの取り出し ------
// getOrElse というメソッドがある
// 引数にNoneの場合の戻り値を指定
def getIntOrZero(option: Option[Int]): Int =
  option.getOrElse(0)

Option(100).getOrElse(0) // Intの100を返す。some(100)ではない
None.getOrElse(0) // Intの0が返る
