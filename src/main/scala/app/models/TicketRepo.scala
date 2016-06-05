package app.models

import com.sun.xml.internal.ws.streaming.TidyXMLStreamReader

/**
  * Created by shinriyo on 6/5/16.
  */
object TicketRepo {

  private var map: Map[Long, Ticket] = Map()

//  def findAll: Seq[Ticket] = ???
  def findAll: Seq[Ticket] = {
//    map.foreach {keyVal => println(keyVal._1 + "=" + keyVal._2)}
    map.valuesIterator.toSeq
  }

  def findById(id: TicketId): Option[Ticket] = {
//    println("a")
    map.get(id)
  }

  def createIssue(title: String): Issue = {
    val id = nextId
    val issue = Issue(
      id,
      title,
      status = TicketStatus.Open
    )
//    None
    issue
  }

//  def nextId: TicketId = ???
  def nextId: TicketId = {
    map.keysIterator.length
  }

  def createBug(title: String, description: String): Bug = {
    val id = nextId//map.keysIterator.length
    val bug = Bug(
      id,
      title,
      description,
      status = TicketStatus.Open
    )
    map = map+(id->bug)
    print(id)
    bug
//    None
  }

  def findIssuesByStatus(status: String): Option[Seq[Issue]] = {
    if(status == "Open")
    {
      map.valuesIterator.filter(
        p=>p.status==TicketStatus.Open && p.getClass == Issue).toList
    }
    else if(status == "Fixed")
    {
      map.valuesIterator.filter(
        p=>p.status==TicketStatus.Fixed && p.getClass == Issue).toList
    }

    None
  }

  def findBugsByStatus(status: String): Option[Seq[Bug]] = {
    if(status == "Open")
    {
      map.valuesIterator.filter(
        p=>p.status==TicketStatus.Open && p.getClass == Bug).toList
    }
    else if(status == "Fixed")
    {
      map.valuesIterator.filter(
        p=>p.status==TicketStatus.Fixed && p.getClass == Bug).toList
    }

    None
  }

//  def fix(id: TicketId): Boolean = ???
  def fix(id: TicketId): Boolean = {
    val res = findById(id).toList
    if(res.length > 0)
    {
      val res2 = findById(id).filter(p=>p.status==TicketStatus.Open).toList;
      if(res2.length > 0)
      {
//        findById(id).filter(p=>p.status==TicketStatus.Open)
        // Tixketを更新したい
        // TODO:
        res2.foreach { value =>
          val res = value
//          res.status = TicketStatus.Fixed
//          res2.updated(Ticket(res.title, res.status))
        }
        return true
      }
    }

    false
  }
}
