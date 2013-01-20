package net.rsemlal.dynamicmixins
import Implicits._

class DynamicMixin[+L, +R](val left: L, val right: R) extends MixableDynamicAny[DynamicMixin[L, R]] {
  val me = this

  def isDynamicMixin = true

  def isDynamicInstanceOf[T](implicit mT: Manifest[T]) = {
    left.isDynamicInstanceOf[T] || right.isDynamicInstanceOf
  }

  def asDynamicInstanceOf[T : Manifest] = {
    if(left.isDynamicInstanceOf[T]) {
      left.asDynamicInstanceOf[T]
    } else {
      right.asDynamicInstanceOf[T]
    }
  }
}