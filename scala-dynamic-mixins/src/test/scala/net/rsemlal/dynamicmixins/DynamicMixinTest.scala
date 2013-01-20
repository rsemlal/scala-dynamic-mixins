package net.rsemlal.dynamicmixins

import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers

import TestData.BeforeA
import TestData.BeforeB
import TestData.A
import TestData.B
import TestData.C
import TestData.V
import TestData.a0
import TestData.b0

class DynamicMixinTest extends FunSpec with ShouldMatchers {
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

    it("should return true with super type of left type") {
      ab0.isDynamicInstanceOf[BeforeA] should be === true
    }

    it("should return true with right type") {
      ab0.isDynamicInstanceOf[B] should be === true
    }

    it("should return true with super type of right type") {
      ab0.isDynamicInstanceOf[BeforeB] should be === true
    }

    it("should return true with common super type") {
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

    it("should return left instance with super type of left type") {
      ab0.asDynamicInstanceOf[BeforeA] should be === a0
    }

    it("should return right instance with right type") {
      ab0.asDynamicInstanceOf[B] should be === b0
    }

     it("should return left instance with super type of right type") {
      ab0.asDynamicInstanceOf[BeforeB] should be === b0
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