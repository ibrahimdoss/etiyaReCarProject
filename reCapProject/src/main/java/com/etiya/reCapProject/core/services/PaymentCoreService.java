package com.etiya.reCapProject.core.services;


public class PaymentCoreService {
	
	public boolean VakıfPayment(String cardName, String cardNumber,String expiration,
			 String cvc,double price) {
	

		double limit = 3000;

		if (price < limit) {

			return true;
		}

		return false;
	
	
}
}
