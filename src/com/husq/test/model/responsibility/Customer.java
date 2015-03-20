package com.husq.test.model.responsibility;

import java.util.Random;

import com.husq.test.model.responsibility.handler.Ceo;
import com.husq.test.model.responsibility.handler.Manager;
import com.husq.test.model.responsibility.handler.PriceHandler;
import com.husq.test.model.responsibility.handler.Salers;

public class Customer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		for(int i=1;i<=100;i++){
			Random random = new Random();
			PriceHandler saler = new Salers();
			PriceHandler manager = new Manager();
			PriceHandler ceo = new Ceo();
			saler.setPriceHandler(manager);
			manager.setPriceHandler(ceo);

			saler.handleRequest(random.nextFloat());
		}
	}

}
