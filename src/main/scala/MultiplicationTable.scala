object MultiplicationTable extends App {
  def createRow(x: Int): String =
    (1 to 10).map(_ * x).map(_.toString).map(value => " " * (4 - value.length) + value).mkString

  def createTable: String =
    (1 to 10).map(createRow).mkString("\n")

  println(createTable)
}
