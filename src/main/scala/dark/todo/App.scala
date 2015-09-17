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
          "handler" -> { todos:Dynamic => todoStorage.save(todos) },
          "deep" -> true
        )
      ),
      "methods" -> json (
        "addTodo" -> {() => {
          val t = g.app
          val newTodo:String = t.newTodo.toString
          if( newTodo.length > 0 ) {
            t.todos.push(json("title" -> newTodo, "completed" -> false))
            t.newTodo = ""
          }
        }},
        "removeTodo" -> {todo: Dynamic => g.app.todos.$remove(todo)},
        "removeCompleted" -> {() =>
          // TODO impl
        }
      ),
      "directives" -> json(
        "todo-focus" -> {value:Dynamic =>
          if( !js.isUndefined(value) && !js.isUndefined(g.app)) {
            g.console.log(value)
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

