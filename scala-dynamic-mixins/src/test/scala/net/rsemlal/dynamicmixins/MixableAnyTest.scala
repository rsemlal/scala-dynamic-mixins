package net.rsemlal.dynamicmixins

import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers
import TestData.A
import TestData.B
import TestData.C
import TestData.V
import TestData.a0
import TestData.b0

class MixableAnyTest extends FunSpec with ShouldMatchers {
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