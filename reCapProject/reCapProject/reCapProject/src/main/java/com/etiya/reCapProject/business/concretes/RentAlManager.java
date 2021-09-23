package com.etiya.reCapProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.reCapProject.business.abstracts.CreditCardService;
import com.etiya.reCapProject.business.abstracts.CustomerFindeksPointCheckService;
import com.etiya.reCapProject.business.abstracts.RentAlService;
import com.etiya.reCapProject.business.constants.Messages;
import com.etiya.reCapProject.core.utilities.businnes.BusinnesRules;
import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.ErrorResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.core.utilities.results.SuccessDataResult;
import com.etiya.reCapProject.core.utilities.results.SuccessResult;
import com.etiya.reCapProject.dataAccess.abstracts.CarDao;
import com.etiya.reCapProject.dataAccess.abstracts.CorporateCustomerDao;
import com.etiya.reCapProject.dataAccess.abstracts.IndividualCustomerDao;
import com.etiya.reCapProject.dataAccess.abstracts.RentAlDao;
import com.etiya.reCapProject.entities.concretes.Car;
import com.etiya.reCapProject.entities.concretes.CorporateCustomer;
import com.etiya.reCapProject.entities.concretes.CreditCard;
import com.etiya.reCapProject.entities.concretes.IndividualCustomer;
import com.etiya.reCapProject.entities.concretes.RentAl;
import com.etiya.reCapProject.entities.requests.creditCardRequest.AddCreditCardRequest;
import com.etiya.reCapProject.entities.requests.rentalRequest.AddRentAlRequest;
import com.etiya.reCapProject.entities.requests.rentalRequest.UpdateRentAlRequest;

@Service
public class RentAlManager implements RentAlService{
	
	private RentAlDao rentAlDao;
	private CarDao carDao;
	private CorporateCustomerDao corporateCustomerDao;
	private IndividualCustomerDao individualCustomerDao;
	private CustomerFindeksPointCheckService checkService;
	private CreditCardService creditCardService;
	
	
	
	@Autowired
	public RentAlManager(RentAlDao rentAlDao, CarDao carDao,CorporateCustomerDao corporateCustomerDao,
			IndividualCustomerDao individualCustomerDao,
			CreditCardService creditCardService,
			CustomerFindeksPointCheckService checkService) {
		super();
		this.rentAlDao = rentAlDao;
		this.carDao=carDao;
		this.corporateCustomerDao=corporateCustomerDao;
		this.individualCustomerDao=individualCustomerDao;
		this.checkService=checkService;
		this.creditCardService=creditCardService;
	}

	@Override
	public DataResult<List<RentAl>> getAll() {
		List<RentAl> rentals= this.rentAlDao.findAll();
		return new SuccessDataResult<List<RentAl>>(rentals,Messages.List);
	}
	
	
	@Override
	public Result addRentalForIndividualCustomer(AddRentAlRequest addRentAlRequest) {
		Car car=new Car();
		car.setCarId(addRentAlRequest.getCarId());
		
		IndividualCustomer individualCustomer= new IndividualCustomer();
		individualCustomer.setId(addRentAlRequest.getCustomerId());
		
		RentAl rentAl=new RentAl();
		rentAl.setRentDate(addRentAlRequest.getRentDate());
		rentAl.setReturnDate(addRentAlRequest.getReturnDate());
		
		rentAl.setCar(car);
		rentAl.setCustomers(individualCustomer);
		

		var result= BusinnesRules.run(checkCarIsSubmit(rentAl.getCar().getCarId()),checkIndiviualCustomerFindexPoint(
				this.individualCustomerDao.getById(addRentAlRequest.getCustomerId()),
				this.carDao.getById(addRentAlRequest.getCarId())));

		if (result!=null) {
			return result;
		}
		
		this.rentAlDao.save(rentAl);
		return new SuccessResult(Messages.Add);
		
	}

	@Override
	public Result updateRentalForIndividualCustomer(UpdateRentAlRequest updateRentAlRequest) {
		Car car=new Car();
		car.setCarId(updateRentAlRequest.getCarId());
		
		IndividualCustomer individualCustomer= new IndividualCustomer();
		individualCustomer.setId(updateRentAlRequest.getCustomerId());	
		
		var result = BusinnesRules.run(checkIndiviualCustomerFindexPoint(
				this.individualCustomerDao.getById(updateRentAlRequest.getCustomerId()),
				this.carDao.getById(updateRentAlRequest.getCarId())));
		
		if (result != null) {
			return result;
		}
		
		RentAl rental = this.rentAlDao.getById(updateRentAlRequest.getCustomerId());
		RentAl rentAl=new RentAl();
		rentAl.setRentDate(updateRentAlRequest.getRentDate());
		rentAl.setReturnDate(updateRentAlRequest.getReturnDate());
		
		rental.setCar(car);
		rental.setCustomers(individualCustomer);
		
		this.rentAlDao.save(rental);
		return new SuccessResult(Messages.Update);
	}

	@Override
	public Result addRentalForCorporateCustomer(AddRentAlRequest addRentAlRequest) {
		Car car=new Car();
		car.setCarId(addRentAlRequest.getCarId());	
		
		CorporateCustomer corporateCustomer=new CorporateCustomer();
		corporateCustomer.setId(addRentAlRequest.getCustomerId());
		
		RentAl rentAl=new RentAl();
		rentAl.setRentDate(addRentAlRequest.getRentDate());
		rentAl.setReturnDate(addRentAlRequest.getReturnDate());
		
		rentAl.setCar(car);
		rentAl.setCustomers(corporateCustomer);
		

		var result= BusinnesRules.run(checkCarIsSubmit(rentAl.getCar().getCarId()),checkCorporateCustomerFindexPoint(
				this.corporateCustomerDao.getById(addRentAlRequest.getCustomerId()),
				this.carDao.getById(addRentAlRequest.getCarId())));

		if (result!=null) {
			return result;
		}
		
		this.rentAlDao.save(rentAl);
		return new SuccessResult(Messages.Add);
		
		
	}

	@Override
	public Result updateRentalForCorporateCustomer(UpdateRentAlRequest updateRentAlRequest) {
		Car car=new Car();
		car.setCarId(updateRentAlRequest.getCarId());
		
		CorporateCustomer corporateCustomer=new CorporateCustomer();
		corporateCustomer.setId(updateRentAlRequest.getCustomerId());
		
		RentAl rentAl=new RentAl();
		rentAl.setRentDate(updateRentAlRequest.getRentDate());
		rentAl.setReturnDate(updateRentAlRequest.getReturnDate());
		
		rentAl.setCar(car);
		rentAl.setCustomers(corporateCustomer);
		
		var result= BusinnesRules.run(checkCarIsSubmit(rentAl.getCar().getCarId()),checkCorporateCustomerFindexPoint(
				this.corporateCustomerDao.getById(updateRentAlRequest.getCustomerId()),
				this.carDao.getById(updateRentAlRequest.getCarId())));

		if (result!=null) {
			return result;
		}
		
		this.rentAlDao.save(rentAl);
		return new SuccessResult(Messages.Update);
	}
	

	
	
	
	public Result checkCarIsSubmit(int carId) {
		for (RentAl rental : this.rentAlDao.getByCar_CarId(carId)) {
			if(rental.getReturnDate() == null ) {
				return new ErrorResult(Messages.RentError);
			}
		}
		return new SuccessResult();
	}
	
	private Result checkIndiviualCustomerFindexPoint(IndividualCustomer individualCustomer,Car car) {
		
		if (this.checkService.checkIndividualCustomerFindexPoint(individualCustomer) <=
				car.getFindexPoint()) {
			return new ErrorResult(Messages.ErrorScore);
		}
		
		return new SuccessResult();
		
		
	}
	
	
	private Result checkCorporateCustomerFindexPoint(CorporateCustomer corporateCustomer,Car car) {
		
		if(this.checkService.checkCorporateCustomerFindexPoint(corporateCustomer) <= car
				.getFindexPoint()) {
			return new ErrorResult(Messages.ErrorScore);
		}
		
		return new SuccessResult();
		
	}
	
	private DataResult<List<CreditCard>> checkSaveCreditCard(AddRentAlRequest addRentAlRequest
			,AddCreditCardRequest addCreditCardRequest){
		
		List<CreditCard> creditCards= creditCardService.getCreditCardByCustomers_CustomerId(addRentAlRequest.getCustomerId()).getData();
		this.addRentalForCorporateCustomer(addRentAlRequest);
		this.addRentalForIndividualCustomer(addRentAlRequest);
		
		if (!creditCards.isEmpty()) {
			return new SuccessDataResult<List<CreditCard>>(creditCards);
		}else {
			this.saveCreditCard(addRentAlRequest.isSaveCreditCard(), addCreditCardRequest);
			return new SuccessDataResult<List<CreditCard>>(Messages.Add);
		}
	}
	
	
	public void saveCreditCard(boolean isSaveCreditCard, AddCreditCardRequest addCreditCardRequest) {
		if (isSaveCreditCard) {
			this.creditCardService.add(addCreditCardRequest);
		}
	}

	
	
	
}
