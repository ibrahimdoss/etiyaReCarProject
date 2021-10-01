package com.example.reCapProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reCapProject.business.abstracts.AllFindexPointCheckService;
import com.example.reCapProject.business.abstracts.RentalService;
import com.example.reCapProject.business.constants.Messages;
import com.example.reCapProject.core.utilities.business.BusinessRules;
import com.example.reCapProject.core.utilities.result.DataResult;
import com.example.reCapProject.core.utilities.result.Result;
import com.example.reCapProject.core.utilities.result.SuccessDataResult;
import com.example.reCapProject.core.utilities.result.SuccessResult;
import com.example.reCapProject.core.utilities.result.ErrorResult;
import com.example.reCapProject.dataAccess.abstracts.CarDao;
import com.example.reCapProject.dataAccess.abstracts.CorporateCustomerDao;
import com.example.reCapProject.dataAccess.abstracts.CustomerDao;
import com.example.reCapProject.dataAccess.abstracts.IndividualCustomerDao;
import com.example.reCapProject.dataAccess.abstracts.RentalDao;
import com.example.reCapProject.entities.concretes.Car;
import com.example.reCapProject.entities.concretes.CorporateCustomer;
import com.example.reCapProject.entities.concretes.Customer;
import com.example.reCapProject.entities.concretes.IndividualCustomer;
import com.example.reCapProject.entities.concretes.Rental;
import com.example.reCapProject.entities.dtos.RentalDetailsDto;
import com.example.reCapProject.entities.request.create.CreateRentalRequest;
import com.example.reCapProject.entities.request.update.UpdateRentalRequest;

@Service
public class RentalManager implements RentalService {

	private RentalDao rentalDao;
	private CarDao carDao;
	private CustomerDao customerDao;
	private IndividualCustomerDao individualCustomerDao;
	private CorporateCustomerDao corporateCustomerDao;
	private AllFindexPointCheckService allFindexPointCheckService;

	@Autowired
	public RentalManager(RentalDao rentalDao, CarDao carDao, CustomerDao customerDao,
			IndividualCustomerDao individualCustomerDao, CorporateCustomerDao corporateCustomerDao,
			AllFindexPointCheckService allFindexPointCheckService) {
		super();
		this.rentalDao = rentalDao;
		this.carDao = carDao;
		this.customerDao = customerDao;
		this.individualCustomerDao = individualCustomerDao;
		this.allFindexPointCheckService = allFindexPointCheckService;
		this.corporateCustomerDao = corporateCustomerDao;
	}

	@Override
	public DataResult<List<Rental>> getAll() {
		return new SuccessDataResult<List<Rental>>(this.rentalDao.findAll(), Messages.RENTALDATESUCCESS);
	}

	@Override
	public DataResult<Rental> getById(int rentalId) {
		return new SuccessDataResult<Rental>(this.rentalDao.getById(rentalId), Messages.RENTALDATESUCCESS);
	}

	@Override
	public Result addCorporateCustomer(CreateRentalRequest createRentalRequest) {
		Car car = new Car();
		car.setCarId(createRentalRequest.getCarId());

		CorporateCustomer corporateCustomer= new CorporateCustomer();
		corporateCustomer.setUserId(createRentalRequest.getCustomerId());

		var result = BusinessRules.run(checkCarIsReturned(createRentalRequest.getCarId()),
				checkCorporateCustomerFindexPoint(this.corporateCustomerDao.getById(createRentalRequest.getCustomerId()),
				this.carDao.getById(createRentalRequest.getCarId())));

		if (result != null) {
			return result;
		}
		Rental rental = new Rental();
		rental.setRentDate(createRentalRequest.getRentDate());
		rental.setCar(car);
		rental.setCustomer(corporateCustomer);;

		this.rentalDao.save(rental);
		return new SuccessResult(Messages.RENTALADD);
	}

	@Override
	public Result addIndividualCustomer(CreateRentalRequest createRentalRequest) {
		Car car = new Car();
		car.setCarId(createRentalRequest.getCarId());
		
		IndividualCustomer individualCustomer= new IndividualCustomer();
		individualCustomer.setUserId(createRentalRequest.getCustomerId());

		var result = BusinessRules.run(checkCarIsReturned(createRentalRequest.getCarId()),
				checkİndiviualCustomerFindexPoint(
						this.individualCustomerDao.getById(createRentalRequest.getCustomerId()),
						this.carDao.getById(createRentalRequest.getCarId())));
		if (result != null) {
			return result;
		}
		Rental rental = new Rental();
		rental.setRentDate(createRentalRequest.getRentDate());
		rental.setCar(car);
		rental.setCustomer(individualCustomer);

		this.rentalDao.save(rental);
		return new SuccessResult(Messages.RENTALADD);
	}

	@Override
	public Result updateCorporateCustomer(UpdateRentalRequest updateRentalRequest) {
		Car car = new Car();
		car.setCarId(updateRentalRequest.getCarId());
		
		CorporateCustomer corporateCustomer= new CorporateCustomer();
		corporateCustomer.setUserId(updateRentalRequest.getCustomerId());

		
		var result = BusinessRules.run(checkCorporateCustomerFindexPoint(
				this.corporateCustomerDao.getById(updateRentalRequest.getCustomerId()),
				this.carDao.getById(updateRentalRequest.getCarId())));
		if (result != null) {
			return result;
		}
		Rental rental = this.rentalDao.getById(updateRentalRequest.getCarId());
		rental.setRentDate(updateRentalRequest.getRentDate());
		rental.setReturnDate(updateRentalRequest.getReturnDate());
		rental.setReturnRentControl(updateRentalRequest.isRentStatus());
		rental.setCar(car);
		rental.setCustomer(corporateCustomer);

		this.rentalDao.save(rental);
		return new SuccessResult(Messages.RENTALUPDATE);
	}

	@Override
	public Result updateIndividualCustomer(UpdateRentalRequest updateRentalRequest) {
		Car car = new Car();
		car.setCarId(updateRentalRequest.getCarId());

		IndividualCustomer individualCustomer = new IndividualCustomer();
		individualCustomer.setUserId(updateRentalRequest.getCustomerId());

		var result = BusinessRules.run(checkİndiviualCustomerFindexPoint(
				this.individualCustomerDao.getById(updateRentalRequest.getCustomerId()),
				this.carDao.getById(updateRentalRequest.getCarId())));
		if (result != null) {
			return result;
		}

		Rental rental = this.rentalDao.getById(updateRentalRequest.getCarId());
		rental.setRentDate(updateRentalRequest.getRentDate());
		rental.setReturnDate(updateRentalRequest.getReturnDate());
		rental.setCar(car);
		rental.setCustomer(individualCustomer);
		rental.setReturnRentControl(updateRentalRequest.isRentStatus());

		this.rentalDao.save(rental);
		return new SuccessResult(Messages.RENTALUPDATE);
	}

	private Result checkCarIsReturned(int carId) {

		RentalDetailsDto rentalDetailsDto = this.rentalDao.getByCarIdWhereReturnDateIsNull(carId);
		if (rentalDetailsDto != null) {
			return new ErrorResult(Messages.RENTALDATEERROR);
		}
		return new SuccessResult();

	}

	private Result checkİndiviualCustomerFindexPoint(IndividualCustomer individualCustomer, Car car) {

		if (this.allFindexPointCheckService.checkIndividualCustomerFindexPoint(individualCustomer) <= car
				.getCarFindeks()) {
			return new ErrorResult(Messages.ERROR);
		}
		return new SuccessResult();
	}

	private Result checkCorporateCustomerFindexPoint(CorporateCustomer corporateCustomer, Car car) {

		if (this.allFindexPointCheckService.checkCorporateCustomerFindexPoint(corporateCustomer) <= car
				.getCarFindeks()) {

			return new ErrorResult(Messages.ERROR);
		}
		return new SuccessResult();
	}

}