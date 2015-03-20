package com.husq.test.model.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TimeHandle implements InvocationHandler {
	private Object target;
	
	public TimeHandle(Object target) {
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		long starttime = System.currentTimeMillis();
		System.out.println("汽车开始行驶:"+starttime);
		
		method.invoke(target);
		
		long endtime = System.currentTimeMillis();
		System.out.println("汽车结束行驶:"+endtime+" ,总共行驶时间："+(endtime-starttime));
		return null;
	}

}
