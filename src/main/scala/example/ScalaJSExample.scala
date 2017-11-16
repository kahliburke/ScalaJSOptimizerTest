package example
import com.thoughtworks.binding.dom
import org.scalajs.dom.raw.Node

import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}

@JSExportTopLevel("example.ScalaJSExample")
object ScalaJSExample {
  @JSExport
  def main(): Unit = {
    dom.render(
      org.scalajs.dom.document.getElementById("binding").asInstanceOf[Node],
      tags)
  }

  // With this level of nesting, the optimizer will optimize away the conversion, resulting in code like
  /*
  var array$2 = [$m_Lorg_scalajs_dom_package$().document__Lorg_scalajs_dom_raw_HTMLDocument().createTextNode("\n          ")];
  var fa$2 = new $c_Lcom_thoughtworks_binding_Binding$Constant().init___O(new $c_Lcom_thoughtworks_binding_Binding$Constant().init___O(new $c_Lcom_thoughtworks_binding_Binding$Constant().init___O(new $c_Lcom_thoughtworks_binding_Binding$Constants().init___sjs_js_Array(array$2))));
  var a$2 = fa$2.value$1;
  var element$macro$23 = $as_Lcom_thoughtworks_binding_Binding(a$2);
   */
  @dom val tags =
    <div>
      <div>
        <div>
          <div>
            Text Content
          </div>
        </div>
      </div>
    </div>

  // Uncomment this method and the optimizer will not optimize away the conversion of Seq to JS array, resulting in code like
  /*
  var a$6 = new $c_sjsr_AnonFunction0().init___sjs_js_Function0((function($this$9, partialAppliedMonadic$macro$8$1$1) {
    return (function() {
      var a$5 = new $c_sjsr_AnonFunction0().init___sjs_js_Function0((function($this$10) {
        return (function() {
          var elements$2 = new $c_sjs_js_WrappedArray().init___sjs_js_Array([$m_Lorg_scalajs_dom_package$().document__Lorg_scalajs_dom_raw_HTMLDocument().createTextNode("\n          ")]);
          var this$26 = $m_sjsr_package$();
          if ($is_sjs_js_ArrayOps(elements$2)) {
            var x2$2 = $as_sjs_js_ArrayOps(elements$2);
            var jsx$3 = x2$2.scala$scalajs$js$ArrayOps$$array$f
          } else if ((elements$2 !== null)) {
            var jsx$3 = elements$2.array$6
          } else {
            var result$4 = [];
            var f$2 = new $c_sjsr_AnonFunction1().init___sjs_js_Function1((function($this$11, result$5) {
              return (function(x$2$2) {
                return $uI(result$5.push(x$2$2))
              })
            })(this$26, result$4));
            $f_sc_IndexedSeqOptimized__foreach__F1__V(elements$2, f$2);
            var jsx$3 = result$4
          };
          return new $c_Lcom_thoughtworks_binding_Binding$Constants().init___sjs_js_Array(jsx$3)
        })
      })($this$9));
      return new $c_Lcom_thoughtworks_binding_Binding$Constant().init___O(a$5.apply__O())
    })
   */
//  @dom val tags =
//    <div>
//      <div>
//        <div>
//          <div>
//            <div>
//              Text Content
//            </div>
//          </div>
//        </div>
//      </div>
//    </div>
}
