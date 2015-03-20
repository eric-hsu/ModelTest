package com.husq.test.model.responsibility.handler;

public abstract class PriceHandler {
	PriceHandler priceHandler;

	public void setPriceHandler(PriceHandler priceHandler) {
		this.priceHandler = priceHandler;
	}
	
	public abstract void handleRequest(float discount);
}
