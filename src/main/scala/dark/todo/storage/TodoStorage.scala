package dark.todo.storage

import dark.todo.model.Todo

trait TodoStorage {
  def save(todos: Seq[Todo]): Unit

  def fetch: Seq[Todo]
}

class TodoStorageImpl extends TodoStorage {
  import scala.scalajs.js.JSON
  import org.scalajs.dom.localStorage
  import TodoStorageImpl._

  def save(todos: Seq[Todo]): Unit = localStorage.setItem(STORAGE_KEY, JSON.stringify(todos))

  def fetch: Dynamic = JSON.parse(localStorage.getItem(STORAGE_KEY))
}

object TodoStorageImpl {
  val STORAGE_KEY = "todos-vuejs"
}
