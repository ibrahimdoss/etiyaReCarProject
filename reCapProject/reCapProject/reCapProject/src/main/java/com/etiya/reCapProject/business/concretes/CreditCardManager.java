package com.etiya.reCapProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.reCapProject.business.abstracts.CreditCardService;
import com.etiya.reCapProject.business.constants.Messages;
import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.core.utilities.results.SuccessDataResult;
import com.etiya.reCapProject.core.utilities.results.SuccessResult;
import com.etiya.reCapProject.dataAccess.abstracts.CreditCardDao;
import com.etiya.reCapProject.entities.concretes.CreditCard;
import com.etiya.reCapProject.entities.concretes.Customer;
import com.etiya.reCapProject.entities.requests.creditCardRequest.AddCreditCardRequest;
import com.etiya.reCapProject.entities.requests.creditCardRequest.DeleteCreditCardRequest;
import com.etiya.reCapProject.entities.requests.creditCardRequest.UpdateCreditCardRequest;

@Service
public class CreditCardManager implements CreditCardService {
	
	private CreditCardDao creditCardDao;
	
	@Autowired
	public CreditCardManager(CreditCardDao creditCardDao) {
		super();
		this.creditCardDao = creditCardDao;
	}

	@Override
	public DataResult<List<CreditCard>> getAll() {
		return new SuccessDataResult<List<CreditCard>>(this.creditCardDao.findAll(), Messages.List);
	}

	@Override
	public DataResult<CreditCard> getById(int id) {
		return new SuccessDataResult<CreditCard>(this.creditCardDao.getById(id),Messages.Listed);
	}

	@Override
	public Result add(AddCreditCardRequest addCreditCardRequest) {
		
		Customer customers=new Customer();
		customers.setId(addCreditCardRequest.getCustomerId());
		
		CreditCard creditCard = new CreditCard();
		creditCard.setCardName(addCreditCardRequest.getCardName());
		creditCard.setCardNumber(addCreditCardRequest.getCardNumber());
		creditCard.setExpiration(addCreditCardRequest.getExpiration());
		creditCard.setCvc(addCreditCardRequest.getCvc());
		
		creditCard.setCustomer(customers);
		
		this.creditCardDao.save(creditCard);
		return new SuccessResult(Messages.Add);
	}

	@Override
	public Result update(UpdateCreditCardRequest updateCreditCardRequest) {
		Customer customers=new Customer();
		customers.setId(updateCreditCardRequest.getCustomerId());
		
		CreditCard creditCard = new CreditCard();
		creditCard.setCardName(updateCreditCardRequest.getCardName());
		creditCard.setCardNumber(updateCreditCardRequest.getCardNumber());
		creditCard.setExpiration(updateCreditCardRequest.getExpiration());
		creditCard.setCvc(updateCreditCardRequest.getCvc());
		creditCard.setCustomer(customers);
		
		this.creditCardDao.save(creditCard);
		return new SuccessResult(Messages.Update);
	}

	@Override
	public Result delete(DeleteCreditCardRequest deleteCreditCardRequest) {
		CreditCard creditCard = new CreditCard();
		creditCard.setCardId(deleteCreditCardRequest.getCardId());
		
		this.creditCardDao.delete(creditCard);
		return new SuccessResult(Messages.Delete);
	}

	@Override
	public DataResult<List<CreditCard>> getCreditCardByCustomers_CustomerId(int customerId) {
		this.creditCardDao.getCreditCardByCustomer_id(customerId);
		return new SuccessDataResult<List<CreditCard>>(Messages.Listed);
	}

	
	
	
	
}
