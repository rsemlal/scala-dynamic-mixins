package net.rsemlal.dynamicmixins

object Implicits {
	implicit def anyToDynamicAny[L](obj: L): DynamicAny = {
	  if(obj.isInstanceOf[DynamicAny]) {
	    obj.asInstanceOf[DynamicAny]
	  } else {
	    new FakeMixableDynamicAny(obj)
	  }
	}

	implicit def fakeToMixableAny[L](obj: FakeMixableDynamicAny[L]): MixableAny[L] = {
		obj
	}

	implicit def anyToMixableAny[L](obj: L): MixableAny[L] = {
		new MixableAny[L] {
		  val me = obj
		}
	}
}