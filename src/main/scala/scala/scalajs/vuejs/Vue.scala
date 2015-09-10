package scala.scalajs.vuejs

import org.scalajs.dom.raw.HTMLElement

import scala.scalajs.js
import scala.scalajs.js.annotation._

@JSName("Vue")
class Vue protected () extends js.Object {
  def this(options: js.Any = ???) = this()
  var paramAttributes: js.Array[js.Any] = js.native
  var template: String = js.native
  var replace: Boolean = js.native
  var created: VueCallback = js.native
  var beforeCompile: VueCallback = js.native
  var compiled: VueCallback = js.native
  var ready: VueCallback = js.native
  var attached: VueCallback = js.native
  var detached: VueCallback = js.native
  var beforeDestroy: VueCallback = js.native
  var destroyed: VueCallback = js.native
  var inherit: Boolean = js.native
  var mixins: js.Array[js.Any] = js.native
  var name: String = js.native
  @JSName("$el")
  var `$el`: HTMLElement = js.native
  @JSName("$parent")
  var `$parent`: Vue = js.native
  @JSName("$root")
  var `$root`: Vue = js.native
  @JSName("$watch")
  def `$watch`(expression: String, callback: ValueCallback, deep: Boolean = ???, immediate: Boolean = ???): Unit = js.native
  @JSName("$get")
  def `$get`(expression: String): js.Dynamic = js.native
  @JSName("$set")
  def `$set`(keypath: String, value: js.Any): Unit = js.native
  @JSName("$add")
  def `$add`(keypath: String, value: js.Any): Unit = js.native
  @JSName("$delete")
  def `$delete`(keypath: String): Unit = js.native
  @JSName("$eval")
  def `$eval`(expression: String): js.Dynamic = js.native
  @JSName("$interpolate")
  def `$interpolate`(templateString: String): String = js.native
  @JSName("$log")
  def `$log`(keypath: String = ???): Unit = js.native
  @JSName("$dispatch")
  def `$dispatch`(event: String, args: js.Any*): Vue = js.native
  @JSName("$broadcast")
  def `$broadcast`(event: String, args: js.Any*): Vue = js.native
  @JSName("$emit")
  def `$emit`(event: String, args: js.Any*): Vue = js.native
  @JSName("$on")
  def `$on`(event: String, callback: js.Function): Vue = js.native
  @JSName("$once")
  def `$once`(event: String, callback: js.Function): Vue = js.native
  @JSName("$off")
  def `$off`(event: String = ???, callback: js.Function = ???): Vue = js.native
  @JSName("$appendTo")
  def `$appendTo`(element: js.Any, callback: js.Function = ???): Vue = js.native
  @JSName("$prependTo")
  def `$prependTo`(element: js.Any, callback: js.Function = ???): Vue = js.native
  @JSName("$before")
  def `$before`(element: js.Any, callback: js.Function = ???): Vue = js.native
  @JSName("$after")
  def `$after`(element: js.Any, callback: js.Function = ???): Vue = js.native
  @JSName("$remove")
  def `$remove`(callback: js.Function = ???): Vue = js.native
  @JSName("$mount")
  def `$mount`(element: js.Any = ???): Vue = js.native
  @JSName("$destroy")
  def `$destroy`(remove: Boolean = ???): Unit = js.native
  @JSName("$compile")
  def `$compile`(element: HTMLElement): VueCallback = js.native
  @JSName("$addChild")
  def `$addChild`(options: js.Any = ???, constructor: js.Function = ???): Vue = js.native
  def _init(options: js.Any): Unit = js.native
  def _cleanup(): Unit = js.native
}

@JSName("Vue")
object Vue extends js.Object {
  var config: VueConfig = js.native
  def extend(options: js.Any): Vue = js.native
  def directive(id: String, definition: js.Any = ???): Unit = js.native
  def filter(id: String, definition: FilterCallback = ???): Unit = js.native
  def component(id: String, definition: Vue): Unit = js.native
  def transition(id: String, definition: js.Any = ???): Unit = js.native
  def partial(id: String, definition: String = ???): Unit = js.native
  def nextTick(callback: VueCallback): Unit = js.native
  def require(module: String): Unit = js.native
  def use(plugin: js.Any, args: js.Any*): Vue = js.native
}

@JSName("VueConfig")
class VueConfig extends js.Object {
  var prefix: String = js.native
  var debug: Boolean = js.native
  var silent: Boolean = js.native
  var proto: Boolean = js.native
  var interpolate: Boolean = js.native
  var async: Boolean = js.native
  var delimiters: js.Array[String] = js.native
}

trait ValueCallback extends js.Object {
  def apply(newValue: js.Any, oldValue: js.Any): Unit = js.native
}

trait VueCallback extends js.Object {
  def apply(): Unit = js.native
}

trait FilterCallback extends js.Object {
  def apply(value: js.Any, begin: js.Any = ???, end: js.Any = ???): js.Any = js.native
}

