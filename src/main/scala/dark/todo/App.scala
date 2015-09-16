package dark.todo

import dark.todo.model.Todo

import scala.scalajs.js
import scala.scalajs.js.Any._
import scala.scalajs.js.Dynamic.{global => g}
import scala.scalajs.js.JSApp
import scala.scalajs.js.annotation.JSExport
import scala.scalajs.vuejs.Vue

import js.Dynamic.{literal => json}

object App extends JSApp {

  val todoStorage = g.todoStorage

//  val filters = json (
//    "all" -> {(todos: Dynamic) => todos},
//    "active" -> {(todos: Dynamic) => todos)}
//  )

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
          "handler" -> {todos:Seq[Todo] => todoStorage.save(todos)},
          "deep" -> true
        )
      ),
      "computed" -> json( //TODO impl
//        "filteredTodos" -> {}
//        "remaining" -> {},
//        "allDone" -> json(
//          "get" -> {},
//          "set" -> {value:Boolean => ()}
//        )
      ),
      "methods" -> json (
        "addTodo" -> {}
      )
    )

    val app = new Vue(option)
    g.hoge = app
  }
}

