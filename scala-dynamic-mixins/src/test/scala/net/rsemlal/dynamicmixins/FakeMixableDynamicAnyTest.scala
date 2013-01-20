package net.rsemlal.dynamicmixins

import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class FakeMixableDynamicAnyTest extends FunSpec with ShouldMatchers {
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
  val fa0 = new FakeMixableDynamicAny(a0)

  describe(classOf[FakeMixableDynamicAny[_]].getSimpleName) {
    it(".isDynamixMixin should be false") {
      fa0.isDynamicMixin should be === false
    }

    it(".me should refer to real instance") {
      fa0.me should be === a0
    }
  }

  describe(classOf[FakeMixableDynamicAny[_]].getSimpleName + ".isDynamicInstanceOf") {
    it("should return true with the real type") {
      fa0.isDynamicInstanceOf[A] should be === true
    }

    it("should return true the super type") {
      fa0.isDynamicInstanceOf[V] should be === true
    }

    it("should return false with another type") {
      fa0.isDynamicInstanceOf[B] should be === false
    }
  }

  describe(classOf[FakeMixableDynamicAny[_]].getSimpleName + ".asDynamicInstanceOf") {
    it("should return real instance with the real type") {
      fa0.asDynamicInstanceOf[A] should be === a0
    }

    it("should return real instace the super type") {
      fa0.asDynamicInstanceOf[V] should be === a0
    }

    it("should raise an exception with another type") {
      intercept[ClassCastException] {
        fa0.asDynamicInstanceOf[B]
      }
    }
  }
}