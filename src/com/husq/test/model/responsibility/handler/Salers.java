package com.husq.test.model.responsibility.handler;

public class Salers extends PriceHandler{

	@Override
	public void handleRequest(float discount) {
		if(discount< 0.2){
			System.out.println(this.getClass().getName()+",处理了"+discount+"的折扣");
		}else{
			priceHandler.handleRequest(discount);
		}
	}

}
