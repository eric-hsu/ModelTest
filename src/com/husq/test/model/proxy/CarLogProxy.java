package com.husq.test.model.proxy;

public class CarLogProxy implements Moveable {
	private Moveable m;
	public CarLogProxy(Moveable m) {
		this.m= m;
	}
	
	@Override
	public void move() {
		long starttime = System.currentTimeMillis();
		System.out.println("日志开始:"+starttime);
		m.move();
		long endtime = System.currentTimeMillis();
		System.out.println("日志结束:"+endtime);
	}

}
