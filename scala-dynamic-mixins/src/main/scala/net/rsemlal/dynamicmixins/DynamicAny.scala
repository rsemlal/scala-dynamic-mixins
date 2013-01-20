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
  def isDynamicInstanceOf[T : Manifest]: Boolean
  def asDynamicInstanceOf[T : Manifest]: T
}