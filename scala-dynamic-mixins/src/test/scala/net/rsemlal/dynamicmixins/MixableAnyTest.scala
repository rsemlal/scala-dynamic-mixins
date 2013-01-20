package net.rsemlal.dynamicmixins

import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers

class MixableAnyTest extends FunSpec with ShouldMatchers {
  trait V {
    val value = this.getClass.getCanonicalName
  }
  class A extends V {
    val attr_a = "a"
  }
  class B extends V {
    val attr_b = "b"
  }

  val a0 = new A()
  val b0 = new B()

  val ma0 = new MixableAny[A] {
    val me = a0
  }

  val ab0 = ma0.mix(b0)

  describe(classOf[MixableAny[_]].getSimpleName + ".me") {
    it("should refer to real instance") {
      ma0.me should be === a0
    }
  }

  describe(classOf[MixableAny[_]].getSimpleName + ".mix") {
    it("should return a dynamic mixin") {
      ab0.isInstanceOf[DynamicMixin[_, _]] should be === true
    }
  }
}