package com.husq.test.model.proxy;

import java.util.Random;

public class Car implements Moveable {

	@Override
	public void move() {
//		long starttime = System.currentTimeMillis();
//		System.out.println("汽车开始行驶:"+starttime);
		try {
			Thread.sleep(new Random().nextInt(1000));
			System.out.println("汽车行驶中！");
		} catch (Exception e) {
			e.printStackTrace();
		}
//		long endtime = System.currentTimeMillis();
//		System.out.println("汽车结束行驶:"+endtime+" ,总共行驶时间："+(endtime-starttime));
	}
}
