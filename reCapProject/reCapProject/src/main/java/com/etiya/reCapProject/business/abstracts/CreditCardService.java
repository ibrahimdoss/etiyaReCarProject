package com.etiya.reCapProject.business.abstracts;

import java.util.List;

import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.entities.concretes.CreditCard;
import com.etiya.reCapProject.entities.requests.AddCreditCardRequest;
import com.etiya.reCapProject.entities.requests.DeleteCreditCardRequest;
import com.etiya.reCapProject.entities.requests.UpdateCreditCardRequest;

public interface CreditCardService {
	
	DataResult<List<CreditCard>> getAll();
	
	DataResult<CreditCard> getById(int id);
	
	Result add(AddCreditCardRequest addCreditCardRequest);
	Result update(UpdateCreditCardRequest updateCreditCardRequest);
	Result delete(DeleteCreditCardRequest deleteCreditCardRequest);
}
