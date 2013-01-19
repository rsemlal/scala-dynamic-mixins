/**
 *
 */
package net.rsemlal.dynamicmixins

/**
 * @author reda
 *
 */
class FakeDynamicAny[+L](val me: L) extends MixableDynamicAny[L] {

  def isDynamicMixin = false

  def isDynamicInstanceOf[T] = me.isInstanceOf[T]

  def asDynamicInstanceOf[T] = me.asInstanceOf[T]
}