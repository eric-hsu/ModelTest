package com.husq.test.model.proxy.jdkproxy;
	import com.husq.test.model.proxy.jdkproxy.MyinvocationHandle;
	import java.lang.reflect.Method;
 public class $MyProxy0 implements com.husq.test.model.proxy.Moveable {
	private MyinvocationHandle h;
	public $MyProxy0(MyinvocationHandle h) {
		this.h= h;
	}
	@Override 
	public void move() {
try{
		Method md = com.husq.test.model.proxy.Moveable.class.getMethod("move");
		h.invoke(this,md);
}catch(Exception e){e.printStackTrace();}
	}
}