package dark.todo.model

import dark.todo.util.JsObjectWrapper

import scala.util.control.Exception._
import scala.scalajs.js.annotation.JSExport
import scala.scalajs.js
import js.Dynamic.{literal => json}
import js.Dynamic

@JSExport
case class Todo(title: String, completed: Boolean = false) {
  def toJsObject: Dynamic = json(
    "title" -> title,
    "completed" -> completed
  )
}

object Todo {
  def apply(todo:js.Dynamic):Option[Todo]  = {
    val obj = JsObjectWrapper(todo)
    for {
      title <- obj.getString("title")
    } yield {
      (
        for {
          c <- obj.getString("completed")
          completed <- catching(classOf[Exception]) opt c.toBoolean
        } yield Todo(title, completed)
        ) match {
        case None => Todo(title, completed = false)
      }
    }
  }
}