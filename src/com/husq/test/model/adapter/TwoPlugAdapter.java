package com.husq.test.model.adapter;

/*
 * 二相转三相的
 * */
public class TwoPlugAdapter implements ThreePlugIf {
	private GBTwoPlug gbTwoPlug;
	public TwoPlugAdapter(GBTwoPlug gbTwoPlug) {
		this.gbTwoPlug = gbTwoPlug;
	}
	@Override
	public void powerWithThree() {
		System.out.println("通过转化");
		gbTwoPlug.powerWithTwo();

	}

}
