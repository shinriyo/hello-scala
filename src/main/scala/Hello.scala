import app.models.TicketRepo

object Hello {
  def main(args: Array[String]): Unit = {
//    println("Hello, world!")
    val res1 = TicketRepo.createBug("最初のバグ", "内容")
    println(res1)
    TicketRepo.createBug("2つめのバグ", "内容2つめ")

    println("----")
    val res2 = TicketRepo.findAll
    res2.foreach(print)
//    for (elem <- res2) {
//      println(elem)
//    }
    println(res2)

    println("----")
    val res3 = TicketRepo.findById(0)
    println(res3)
    val res4 = TicketRepo.findById(1)
    println(res4)
    val res5 = TicketRepo.findById(2)
    println(res5)

    println("----")
    val res6 = TicketRepo.createIssue("問題")
    println(res6)

    println("----")
    val res7 = TicketRepo.findBugsByStatus("Open")
    res7.foreach(print)
//    for (elem <- res7) {
//      println(elem)
//    }
    val res8 = TicketRepo.findBugsByStatus("Fixed")
    res8.foreach(print)
//    for (elem <- res8) {
//      println(elem)
//    }

    println("----")
    val res9 = TicketRepo.fix(1)
    println(res9)
    println("----")

    val res10 = TicketRepo.findAll
    res10.foreach(print)
//    for (elem <- res10) {
//      println(elem)
//    }
  }
}
