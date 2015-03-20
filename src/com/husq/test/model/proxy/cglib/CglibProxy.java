package com.husq.test.model.proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor {
	
	private Enhancer enhancer = new Enhancer();
	
	public Object getProxy(Class clazz){
		enhancer.setSuperclass(clazz);
		enhancer.setCallback(this);
		return enhancer.create();
	}
	
	/*
	 * 拦截所有目标类方法的调用
	 * obj 目标类的实例
	 * m 目标方法的反射对象
	 * args 方法的参数
	 * proxy 代理类的实例
	 * */
	public Object intercept(Object obj, Method m, Object[] args,
			MethodProxy proxy) throws Throwable {
		// TODO Auto-generated method stub
		
		long starttime = System.currentTimeMillis();
		System.out.println("火车开始行驶:"+starttime);
		
		//代理类调用父类的方法
		proxy.invokeSuper(obj, args);
		
		long endtime = System.currentTimeMillis();
		System.out.println("火车结束行驶:"+endtime+" ,总共行驶时间："+(endtime-starttime));
		return null;
	}

}
