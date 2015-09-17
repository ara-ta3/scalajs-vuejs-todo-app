package dark.todo.storage

import scala.scalajs.js
import scala.scalajs.js._
import scala.scalajs.js.annotation.JSExport
import js.Dynamic.{literal => json}

class TodoStorage {
  import org.scalajs.dom.localStorage
  import TodoStorage._

  val save: js.Function1[js.Array[Dynamic], Unit] = {(todos: js.Array[Dynamic]) => {
    localStorage.setItem(STORAGE_KEY, JSON.stringify(todos))
  }}

  val fetch: js.Function0[js.Any] = { () =>
    Option(JSON.parse(localStorage.getItem(STORAGE_KEY)))
      .getOrElse(js.Array())

  }
}

object TodoStorage extends JSApp {
  val STORAGE_KEY = "todos-vuejs"

  @JSExport
  override def main(): Unit = {
    val storage = new TodoStorage
    scala.scalajs.js.Dynamic.global.todoStorage = json(
      "fetch" -> storage.fetch,
      "save" -> storage.save
    )
  }
}
