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
import com.etiya.reCapProject.dataAccess.abstracts.CareDao;
import com.etiya.reCapProject.dataAccess.abstracts.CorporateCustomerDao;
import com.etiya.reCapProject.dataAccess.abstracts.IndividualCustomerDao;
import com.etiya.reCapProject.dataAccess.abstracts.RentAlDao;
import com.etiya.reCapProject.entities.concretes.Car;
import com.etiya.reCapProject.entities.concretes.Care;
import com.etiya.reCapProject.entities.concretes.CorporateCustomer;
import com.etiya.reCapProject.entities.concretes.IndividualCustomer;
import com.etiya.reCapProject.entities.concretes.RentAl;
import com.etiya.reCapProject.entities.requests.rentalRequest.AddRentAlRequest;
import com.etiya.reCapProject.entities.requests.rentalRequest.DeleteRentAlRequest;
import com.etiya.reCapProject.entities.requests.rentalRequest.UpdateRentAlRequest;

@Service
public class RentAlManager implements RentAlService{
	
	private RentAlDao rentAlDao;
	private CarDao carDao;
	private CorporateCustomerDao corporateCustomerDao;
	private IndividualCustomerDao individualCustomerDao;
	private CustomerFindeksPointCheckService checkService;
	private CareDao careDao;
	
	
	
	@Autowired
	public RentAlManager(RentAlDao rentAlDao, CarDao carDao,CorporateCustomerDao corporateCustomerDao,
			IndividualCustomerDao individualCustomerDao,
			CreditCardService creditCardService,
			CareDao careDao,
			CustomerFindeksPointCheckService checkService) {
		super();
		this.rentAlDao = rentAlDao;
		this.carDao=carDao;
		this.corporateCustomerDao=corporateCustomerDao;
		this.individualCustomerDao=individualCustomerDao;
		this.checkService=checkService;
		this.careDao=careDao;
	}

	@Override
	public DataResult<List<RentAl>> getAll() {
		List<RentAl> rentals= this.rentAlDao.findAll();
		return new SuccessDataResult<List<RentAl>>(rentals,Messages.List);
	}
	
	
	@Override
	public Result addRentalForIndividualCustomer(AddRentAlRequest addRentAlRequest) {
		Car car=this.carDao.getById(addRentAlRequest.getCarId());
		
		//teslim ettikten sonraki teslim edilen il
		car.setCity(addRentAlRequest.getReturnCity());
		this.carDao.save(car);

		
		IndividualCustomer individualCustomer= new IndividualCustomer();
		individualCustomer.setId(addRentAlRequest.getCustomerId());
		
		RentAl rentAl=new RentAl();
		rentAl.setRentDate(addRentAlRequest.getRentDate());
		rentAl.setReturnDate(addRentAlRequest.getReturnDate());
		
		//kiralamadan önceki başlangıç şehiri.
		rentAl.setTakeCity(car.getCity());
		rentAl.setStartKilometer(addRentAlRequest.getStartKilometer());
		rentAl.setReturnCity(addRentAlRequest.getReturnCity());
		
		car.setKilometer(addRentAlRequest.getStartKilometer()+car.getKilometer());
		
		rentAl.setCar(car);
		rentAl.setCustomers(individualCustomer);
		

		var result= BusinnesRules.run(checkCarIsSubmit(rentAl.getCar().getCarId()),checkIndiviualCustomerFindexPoint(
				this.individualCustomerDao.getById(addRentAlRequest.getCustomerId()),
				this.carDao.getById(addRentAlRequest.getCarId())),checkIsCarCare(addRentAlRequest.getCarId()),checkIsCarCare(addRentAlRequest.getCarId()));

		if (result!=null) {
			return result;
		}
		
		this.rentAlDao.save(rentAl);
		return new SuccessResult(Messages.Add);
		
	}

	@Override
	public Result updateRentalForIndividualCustomer(UpdateRentAlRequest updateRentAlRequest) {
		Car car=this.carDao.getById(updateRentAlRequest.getCarId());
		car.setCity(updateRentAlRequest.getReturnCity());
		this.carDao.save(car);
	
		
		IndividualCustomer individualCustomer= new IndividualCustomer();
		individualCustomer.setId(updateRentAlRequest.getCustomerId());	
		
		var result = BusinnesRules.run(checkIndiviualCustomerFindexPoint(
				this.individualCustomerDao.getById(updateRentAlRequest.getCustomerId()),
				this.carDao.getById(updateRentAlRequest.getCarId())),checkIsCarCare(updateRentAlRequest.getCarId()));
		
		if (result != null) {
			return result;
		}
		
		RentAl rental = this.rentAlDao.getById(updateRentAlRequest.getCustomerId());
		RentAl rentAl=new RentAl();
		rentAl.setRentDate(updateRentAlRequest.getRentDate());
		rentAl.setReturnDate(updateRentAlRequest.getReturnDate());
		rental.setStartKilometer(updateRentAlRequest.getStartKilometer());
		rentAl.setTakeCity(car.getCity());
		car.setKilometer(updateRentAlRequest.getStartKilometer()+car.getKilometer());

		
		rental.setCar(car);
		rental.setCustomers(individualCustomer);
		
		this.rentAlDao.save(rental);
		return new SuccessResult(Messages.Update);
	}

	@Override
	public Result addRentalForCorporateCustomer(AddRentAlRequest addRentAlRequest) {
		Car car=this.carDao.getById(addRentAlRequest.getCarId());
		//teslim ettikten sonraki teslim edilen il
		car.setCity(addRentAlRequest.getReturnCity());	
		this.carDao.save(car);
		
		
		CorporateCustomer corporateCustomer=new CorporateCustomer();
		corporateCustomer.setId(addRentAlRequest.getCustomerId());
		

		var result= BusinnesRules.run(checkCarIsSubmit(addRentAlRequest.getCarId()),checkCorporateCustomerFindexPoint(
				this.corporateCustomerDao.getById(addRentAlRequest.getCustomerId()),
				this.carDao.getById(addRentAlRequest.getCarId())),checkIsCarCare(addRentAlRequest.getCarId()));

		if (result!=null) {
			return result;
		}
		
		RentAl rentAl=new RentAl();
		rentAl.setRentDate(addRentAlRequest.getRentDate());
		rentAl.setReturnDate(addRentAlRequest.getReturnDate());
		rentAl.setStartKilometer(addRentAlRequest.getStartKilometer());
		
		//kiralamadan önceki başlangıç şehiri.
		rentAl.setTakeCity(car.getCity());
		rentAl.setReturnCity(addRentAlRequest.getReturnCity());
		
		car.setKilometer(addRentAlRequest.getStartKilometer()+car.getKilometer());

		rentAl.setCar(car);
		rentAl.setCustomers(corporateCustomer);
		

		
		this.rentAlDao.save(rentAl);
		return new SuccessResult(Messages.Add);
		
		
	}

	@Override
	public Result updateRentalForCorporateCustomer(UpdateRentAlRequest updateRentAlRequest) {
		Car car=this.carDao.getById(updateRentAlRequest.getCarId());
		//teslim ettikten sonraki teslim edilen il
		car.setCity(updateRentAlRequest.getReturnCity());	
		this.carDao.save(car);

		
		CorporateCustomer corporateCustomer=new CorporateCustomer();
		corporateCustomer.setId(updateRentAlRequest.getCustomerId());
		
		RentAl rentAl=new RentAl();
		rentAl.setRentAlId(updateRentAlRequest.getRentAlId());
		rentAl.setRentDate(updateRentAlRequest.getRentDate());
		rentAl.setReturnDate(updateRentAlRequest.getReturnDate());
		rentAl.setTakeCity(updateRentAlRequest.getTakeCity());
		rentAl.setStartKilometer(updateRentAlRequest.getStartKilometer());
		car.setKilometer(updateRentAlRequest.getStartKilometer()+car.getKilometer());


		
		//kiralamadan önceki başlangıç şehiri.
		rentAl.setTakeCity(car.getCity());
		
		rentAl.setCar(car);
		rentAl.setCustomers(corporateCustomer);
		
		var result= BusinnesRules.run(checkCarIsSubmit(rentAl.getCar().getCarId()),checkCorporateCustomerFindexPoint(
				this.corporateCustomerDao.getById(updateRentAlRequest.getCustomerId()),
				this.carDao.getById(updateRentAlRequest.getCarId())),checkIsCarCare(updateRentAlRequest.getCarId()));

		if (result!=null) {
			return result;
		}
		
		this.rentAlDao.save(rentAl);
		return new SuccessResult(Messages.Update);
	}
	
	
	
	@Override
	public Result delete(DeleteRentAlRequest deleteRentAlRequest) {
		RentAl rentAl= this.rentAlDao.getById(deleteRentAlRequest.getRentAlId());
		
		this.rentAlDao.save(rentAl);
		return new SuccessResult(Messages.Delete);
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
	
	
	private Result checkIsCarCare(int carId) {
		if (this.careDao.getByCar_CarId(carId).size() != 0) {
			Care care= this.careDao.getByCar_CarId(carId)
					.get(this.careDao.getByCar_CarId(carId).size()-1);
			
			
			if (care.getFinishDate()==null) {
				return new ErrorResult(Messages.rentalcareError);
		}
		
		}
		return new SuccessResult();
	}


	
	

	
	
	
}
