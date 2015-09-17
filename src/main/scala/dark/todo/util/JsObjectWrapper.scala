package dark.todo.util

import scala.scalajs.js

class JsObjectWrapper(obj: js.Dynamic) {
  def getString(key:String): Option[String] =
    if(js.isUndefined(obj.selectDynamic(key))) None else Some(obj.selectDynamic(key).toString)
}

object JsObjectWrapper {
  def apply(obj: js.Dynamic): JsObjectWrapper = new JsObjectWrapper(obj)

}

