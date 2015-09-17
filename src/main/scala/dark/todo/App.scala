package dark.todo

import scala.scalajs.js.Dynamic
import scala.scalajs.js
import scala.scalajs.js.Any._
import scala.scalajs.js.Dynamic.{global => g, literal => json}
import scala.scalajs.js.JSApp
import scala.scalajs.js.annotation.JSExport
import scala.scalajs.vuejs.{Vue, VueCallback}

object App extends JSApp {

  val todoStorage = g.todoStorage

  @JSExport
  def main():Unit = {
    val option = json(
      "el" -> ".todoapp",
      "data" -> json(
        "todos" -> todoStorage.fetch(),
        "newTodo" -> "",
        "editedTodo" -> null,
        "visibility" -> "all"
      ),
      "watch" -> json(
        "todos" -> json(
          "handler" -> {todos:js.Any => todoStorage.save(todos)},
          "deep" -> true
        )
      ),
      "methods" -> json (
        "addTodo" -> addTodo,
        "removeTodo" -> removeTodo,
        "removeCompleted" -> removeCompleted
      )
    )

    g.app = new Vue(option)
  }

  private val addTodo: () => Unit = {() => {
    val t = g.app
    val newTodo:String = t.newTodo.toString
    if( newTodo.length > 0 ) {
      t.todos.push(json("title" -> newTodo, "completed" -> false))
      t.newTodo = ""
    }
  }}

  private val removeCompleted: () => Unit = {() =>

  }

  private val removeTodo: Dynamic => Unit = {todo =>
    g.app.todos.$remove(todo)
  }

  class NextTickCallBack extends VueCallback {
    override def apply(): Unit = g.app.el.focus()
  }
}

