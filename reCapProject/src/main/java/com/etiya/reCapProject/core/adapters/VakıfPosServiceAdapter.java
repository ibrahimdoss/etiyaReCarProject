package com.etiya.reCapProject.core.adapters;

import org.springframework.stereotype.Service;

import com.etiya.reCapProject.business.abstracts.CreatePosService;
import com.etiya.reCapProject.core.services.PaymentCoreService;
import com.etiya.reCapProject.entities.requests.posRequest.PosRequest;

@Service
public class VakıfPosServiceAdapter implements CreatePosService {
	
	PaymentCoreService paymentCoreService = new PaymentCoreService();

	@Override
	public boolean payment(PosRequest posRequest) {
		
		return paymentCoreService.VakıfPayment(posRequest.getCardName(), posRequest.getCardNumber(),
				posRequest.getExpiration(), posRequest.getCvc(),posRequest.getPrice());
		
		
		
		
	}
	
}
