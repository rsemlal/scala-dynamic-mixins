package net.rsemlal.dynamicmixins

trait MixableAny[+L]  {
  val me: L
  def mix[R](right: R) =
    new DynamicMixin(me, right)
}