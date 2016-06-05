package app.models

/**
  * Created by shinriyo on 6/5/16.
  */
trait Ticket {
  val id: Long
  val title: String
//  val status: TicketStatus = TicketStatus.Open
  val status: TicketStatus
}

//object Foo extends TicketStatus

case class Issue (
  id: Long,
  title: String,
  status: TicketStatus
) extends Ticket
case class Bug(
  id: Long,
  title: String="2",
  description: String="22",
  status: TicketStatus = TicketStatus.Open
) extends Ticket
//object Bug {
//  def apply(id: Long, title: String, status: TicketStatus)= {
//    new Bug(var title)
//  }
//}
