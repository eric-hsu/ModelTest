package com.husq.test.model.adapter;

public class NoteBook {
	private ThreePlugIf plug;
	public NoteBook(ThreePlugIf plug) {
		this.plug=plug;
	}
	public void charge(){
		plug.powerWithThree();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//1 使用组合的方式实现适配器
		GBTwoPlug two = new GBTwoPlug();
		ThreePlugIf plug = new TwoPlugAdapter(two);
		NoteBook noteBook = new NoteBook(plug);
		noteBook.charge();
		
		//1 使用继承的方式实现适配器
		ThreePlugIf plug2 = new TwoPlugAdapterExtends();
		NoteBook noteBook2 = new NoteBook(plug2);
		noteBook2.charge();
	}

}
