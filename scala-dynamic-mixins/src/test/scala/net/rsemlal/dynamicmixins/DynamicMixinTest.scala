package net.rsemlal.dynamicmixins

import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers

class DynamicMixinTest extends FunSpec with ShouldMatchers {
  trait V {
    val value = this.getClass.getCanonicalName
  }
  class A extends V {
    val attr_a = "a"
  }
  class B extends V {
    val attr_b = "b"
  }
  class C extends V {
    val attr_c = "c"
  }

  val a0 = new A()
  val b0 = new B()
  val ab0 = new DynamicMixin(a0, b0)

  describe(classOf[DynamicMixin[_, _]].getSimpleName) {
    it("me should return the mixed instance") {
      ab0.me should be === ab0
    }

    it("left should return the left instance") {
      ab0.left should be === a0
    }

    it("right should return the right instance") {
      ab0.right should be === b0
    }
  }

  describe(classOf[DynamicMixin[_, _]].getSimpleName + ".isDynamicInstanceOf") {
    it("should return true with left type") {
      ab0.isDynamicInstanceOf[A] should be === true
    }

    it("should return true with right type") {
      ab0.isDynamicInstanceOf[B] should be === true
    }

    it("should return true with super type") {
      ab0.isDynamicInstanceOf[V] should be === true
    }

    it("should return false with another type") {
      ab0.isDynamicInstanceOf[C] should be === false
    }
  }

  describe(classOf[DynamicMixin[_, _]].getSimpleName + ".asDynamicInstanceOf") {
    it("should return left instance with left type") {
      ab0.asDynamicInstanceOf[A] should be === a0
    }

    it("should return right instance with right type") {
      ab0.asDynamicInstanceOf[B] should be === b0
    }

    it("should return left instance with super type") {
      ab0.asDynamicInstanceOf[V] should be === a0
    }

    it("should throw exception with another type") {
      intercept[ClassCastException] {
        ab0.asDynamicInstanceOf[C]
      }
    }
  }
}