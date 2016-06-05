package app.models

/**
  * Created by shinriyo on 6/5/16.
  */
sealed trait TicketStatus {
}

object TicketStatus {
  case object Open extends TicketStatus
  case object Fixed extends TicketStatus
//  class CFixed extends TicketStatus
//  trait TFixed extends TicketStatus
}

// class クラス名 extends 親クラス名 with トレイト1 with トレイト2


//class Fixed extends TicketStatus with TicketStatus
