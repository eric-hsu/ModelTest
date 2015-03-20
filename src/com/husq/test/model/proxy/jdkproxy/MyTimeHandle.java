package com.husq.test.model.proxy.jdkproxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyTimeHandle implements MyinvocationHandle {
	private Object target;
	
	public MyTimeHandle(Object target) {
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method){
		try {
			long starttime = System.currentTimeMillis();
			System.out.println("汽车开始行驶:"+starttime);
			method.invoke(target);
			long endtime = System.currentTimeMillis();
			System.out.println("汽车结束行驶:"+endtime+" ,总共行驶时间："+(endtime-starttime));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
