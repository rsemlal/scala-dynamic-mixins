package net.rsemlal.dynamicmixins

trait MixableDynamicAny[+L] extends DynamicAny {
  val me: L
  def mix[R](right: R) =
    new DynamicMixin(me, right)
}