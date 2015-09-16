package dark.todo

import dark.todo.model.Todo

import scala.scalajs.js
import scala.scalajs.js.Any._
import scala.scalajs.js.Dynamic.{global => g}
import scala.scalajs.js.JSApp
import scala.scalajs.js.annotation.JSExport
import scala.scalajs.vuejs.{VueCallback, Vue}

import js.Dynamic.{literal => json}

object App extends JSApp {

  val todoStorage = g.todoStorage

  val filters = json (
    "all" -> {(todos: Dynamic) => todos},
    "active" -> {(todos: Dynamic) =>
      // TODO filter
      todos
    },
    "completed" -> {(todos: Dynamic) =>
      // TODO filter
      todos
    }
  )

  @JSExport
  def main():Unit = {
    val option = json(
      "el" -> ".todoapp",
      "data" -> json(
        "todos" -> todoStorage.fetch,
        "newTodo" -> "",
        "editedTodo" -> null,
        "visibility" -> "all"
      ),
      "watch" -> json(
        "todo" -> json(
          "handler" -> {todos:js.Any => todoStorage.save(todos)},
          "deep" -> true
        )
      ),
      "computed" -> json( //TODO impl
//        "filteredTodos" -> {() => filters}
//        "remaining" -> {},
//        "allDone" -> json(
//          "get" -> {},
//          "set" -> {value:Boolean => ()}
//        )
      ),
      "methods" -> json (
        "addTodo" -> {() =>
        }
      ),
      "directives" -> json(
        "todo-focus" -> {(value: js.Any) =>
          for {
            _ <- Option(value)
          } yield Vue.nextTick(new NextTickCallBack)
        }
      )
    )

    g.app = new Vue(option)
  }

  class NextTickCallBack extends VueCallback {
    override def apply(): Unit = g.app.el.focus()
  }
}

