package net.rsemlal.dynamicmixins

object Implicits {
	implicit def anyToDynamicAny[L](obj: L): MixableDynamicAny[L] = {
	  if(obj.isInstanceOf[DynamicAny]) {
	    obj.asInstanceOf[MixableDynamicAny[L]]
	  } else {
	    new FakeDynamicAny(obj)
	  }
	}
}