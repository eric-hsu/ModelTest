package com.jinxin.test.proxy;
public class Proxy0 implements Moveable {
	private Moveable m;
	public Proxy0(Moveable m) {
		this.m= m;
	}
	@Override 
	public void move() {
		long starttime = System.currentTimeMillis();
		System.out.println("汽车开始行驶:"+starttime);
		m.move();
		long endtime = System.currentTimeMillis();
		System.out.println("汽车结束行驶:"+endtime+" ,总共行驶时间："+(endtime-starttime));
	}
}