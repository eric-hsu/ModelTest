package com.husq.test.model.proxy;

import java.lang.reflect.Method;

import com.husq.test.model.proxy.jdkproxy.MyProxy;
import com.husq.test.model.proxy.jdkproxy.MyTimeHandle;
import com.husq.test.model.proxy.jdkproxy.MyinvocationHandle;

public class Client {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//		Car car = new Car();
//		car.move();
		
		//1 使用继承的方式使用静态代理
//		Moveable car1 = new Car1();
//		car1.move();
		
		//2 使用聚合的方式
//		Car carx = new Car();
//		Moveable car2 = new Car2(carx);
//		car2.move();
		
		//3 使用聚合方式
//		Car carp = new Car();
//		CarTimeProxy carTimeProxy = new CarTimeProxy(carp);
//		CarLogProxy carLogProxy = new CarLogProxy(carTimeProxy);
//		carLogProxy.move();
		
		//4 使用jdk动态代理
//		Car cari = new Car();
//		InvocationHandler handler = new TimeHandle(cari);
//		Moveable moveable = (Moveable) Proxy.newProxyInstance(cari.getClass().getClassLoader(), cari.getClass().getInterfaces(), handler);
//		System.out.println(moveable.getClass().getName());
//		moveable.move();
		
		//5 使用cglib动态代理
//		CglibProxy proxy = new CglibProxy();
//		Train t= (Train)proxy.getProxy(Train.class);
//		t.move();
		
		//6 自己实现动态代理（好复杂）
		Car car = new Car();
		MyinvocationHandle myinvocationHandle = new MyTimeHandle(car);
		Moveable m = (Moveable) MyProxy.newProxyInstance(Moveable.class,myinvocationHandle);
		m.move();
	}

}
