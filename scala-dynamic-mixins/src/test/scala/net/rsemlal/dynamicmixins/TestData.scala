package net.rsemlal.dynamicmixins

object TestData {
  trait V {
    val value = this.getClass.getCanonicalName
  }

  trait BeforeA extends V {
    val attr_ba = "a"
  }

  trait BeforeB extends V {
    val attr_bb = "b"
  }

  trait BeforeC extends V {
    val attr_bc = "c"
  }

  class A extends BeforeA {
    val attr_a = "a"
  }

  class B extends BeforeB {
    val attr_b = "b"
  }

  class C extends BeforeC {
    val attr_c = "c"
  }

  val a0 = new A()
  val b0 = new B()
  val c0 = new B()
}