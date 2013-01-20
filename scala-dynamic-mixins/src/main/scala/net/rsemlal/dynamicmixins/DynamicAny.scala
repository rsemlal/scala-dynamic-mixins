/**
 *
 */
package net.rsemlal.dynamicmixins

/**
 * @author rsemlal
 *
 */
trait DynamicAny {
  def isDynamicMixin: Boolean
  def isDynamicInstanceOf[T](implicit mT: Manifest[T]): Boolean
  def asDynamicInstanceOf[T]: T
}