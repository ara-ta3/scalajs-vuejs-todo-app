package dark.todo

import dark.todo.model.Todo
import dark.todo.storage.TodoStorageImpl

import scala.scalajs.js
import scala.scalajs.js.Any._
import scala.scalajs.js.Dynamic.{global => g}
import scala.scalajs.js.JSApp
import scala.scalajs.js.annotation.JSExport
import scala.scalajs.vuejs.Vue

import js.Dynamic.{literal => json}

object App extends JSApp {

  val todoStorage = new TodoStorageImpl

  @JSExport
  def main():Unit = {
    val option = json(
      "el" -> ".todoapp",
      "data" -> js.Dynamic.literal(
        "todos" -> todoStorage.fetch.toString, //FIXME Dynamic
        "newTodo" -> "",
        "editedTodo" -> null,
        "visibility" -> "all"
      ),
      "watch" -> json(
        "todo" -> json(
          "handler" -> {todos:Seq[Todo] => todoStorage.save(todos)},
          "deep" -> true
        )
      ),
      "computed" -> json( //TODO impl
        "filteredTodos" -> {},
        "remaining" -> {},
        "allDone" -> json(
          "get" -> {},
          "set" -> {value:Boolean => ()}
        )
      )
    )

    val app = new Vue(option)
  }
}

