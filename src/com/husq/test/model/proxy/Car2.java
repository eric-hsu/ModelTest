package com.husq.test.model.proxy;

public class Car2 implements Moveable {
	private Car car;
	
	public Car2(Car car) {
		this.car= car;
	}
	
	@Override
	public void move() {
		long starttime = System.currentTimeMillis();
		System.out.println("汽车开始行驶:"+starttime);
		car.move();
		long endtime = System.currentTimeMillis();
		System.out.println("汽车结束行驶:"+endtime+" ,总共行驶时间："+(endtime-starttime));
	}
}
