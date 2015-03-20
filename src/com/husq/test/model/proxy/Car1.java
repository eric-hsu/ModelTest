package com.husq.test.model.proxy;

import java.util.Random;

public class Car1 extends Car {
	@Override
	public void move() {
		long starttime = System.currentTimeMillis();
		System.out.println("汽车开始行驶:"+starttime);
		super.move();
		long endtime = System.currentTimeMillis();
		System.out.println("汽车结束行驶:"+endtime+" ,总共行驶时间："+(endtime-starttime));
	}
}
