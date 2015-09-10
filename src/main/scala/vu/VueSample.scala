package vu

import scala.scalajs.js.Dynamic.{global => g}
import scala.scalajs.js
import scala.scalajs.js.JSApp
import scala.scalajs.js.annotation.JSExport
import scala.scalajs.js.Any._
import scala.scalajs.vuejs.Vue

object VueSample extends JSApp {

  @JSExport
  def main():Unit = {
    val option = js.Dynamic.literal(
      "el" -> "#editor",
      "data" -> js.Dynamic.literal(
        "input" -> "# hello"
      ),
      "filters" -> js.Dynamic.literal(
        "marked" -> g.marked
      )
    )

    val app = new Vue(option)
  }
}

