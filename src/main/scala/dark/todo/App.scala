package dark.todo

import dark.todo.model.Todo

import scala.scalajs.js
import scala.scalajs.js.Any._
import scala.scalajs.js.Dynamic.{global => g, literal => json}
import scala.scalajs.js.{Dynamic, JSApp}
import scala.scalajs.js.annotation.JSExport
import scala.scalajs.vuejs.Vue

object App extends JSApp {


  val state = App(g)

  @JSExport
  def main():Unit = {
    val option = json(
      "el" -> ".todoapp",
      "data" -> json(
        "todos" -> state.fetchTodos,
        "newTodo" -> "",
        "editedTodo" -> null,
        "visibility" -> "all"
      ),
      "watch" -> json(
        "todos" -> json(
          "handler" -> { todos:js.Array[Dynamic] => state.saveTodos(todos) },
          "deep" -> true
        )
      ),
      "methods" -> json (
        "addTodo" -> {() => {
          state.takeNewTodo
          state.init
        }},
        "removeTodo" -> {todo: Dynamic => g.app.todos.$remove(todo)},
        "removeCompleted" -> {() =>
          // TODO impl
        }
      ),
      "directives" -> json(
        "todo-focus" -> {value:Dynamic =>
          if( !js.isUndefined(value) && !js.isUndefined(g.app)) {
            Vue.nextTick({() =>
              g.app.$el.focus()
            })
          }
        }
      )
    )

    g.app = new Vue(option)
  }
}

case class App(g: Dynamic) {

  private val todoStorage = g.todoStorage

  def init: Unit = {
    g.app.newTodo = ""
  }

  def takeNewTodo: Unit = {
    val app  = g.app
    val todo = Todo(app.newTodo.toString)
    app.todos.push(todo.toJsObject)
  }

  def fetchTodos: Dynamic = todoStorage.fetch()

  def saveTodos(todos: js.Array[Dynamic]) = todoStorage.save(todos)
}
