package com.husq.test.model.adapter;

public class TwoPlugAdapterExtends extends GBTwoPlug implements ThreePlugIf {

	@Override
	public void powerWithThree() {
		System.out.println("借助继承方式转换适配");
		this.powerWithTwo();
	}

}
