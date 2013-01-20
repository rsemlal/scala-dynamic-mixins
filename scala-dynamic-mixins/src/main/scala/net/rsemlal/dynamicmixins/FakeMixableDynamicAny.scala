/**
 *
 */
package net.rsemlal.dynamicmixins

import scala.reflect.ClassManifest
import scala.reflect.Manifest

/**
 * @author reda
 *
 */
class FakeMixableDynamicAny[+L](val me: L) extends MixableDynamicAny[L] {

  def isDynamicMixin = false

  def isDynamicInstanceOf[T](implicit mT: Manifest[T]) = mT.erasure.isInstance(me)

  def asDynamicInstanceOf[T] = me.asInstanceOf[T]
}