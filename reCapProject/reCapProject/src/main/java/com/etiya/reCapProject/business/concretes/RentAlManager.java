package com.etiya.reCapProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.reCapProject.business.abstracts.RentAlService;
import com.etiya.reCapProject.business.constants.Messages;
import com.etiya.reCapProject.core.utilities.businnes.BusinnesRules;
import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.ErrorResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.core.utilities.results.SuccessDataResult;
import com.etiya.reCapProject.core.utilities.results.SuccessResult;
import com.etiya.reCapProject.dataAccess.abstracts.RentAlDao;
import com.etiya.reCapProject.entities.concretes.Car;
import com.etiya.reCapProject.entities.concretes.Customers;
import com.etiya.reCapProject.entities.concretes.RentAl;
import com.etiya.reCapProject.entities.requests.AddRentAlRequest;
import com.etiya.reCapProject.entities.requests.DeleteRentAlRequest;
import com.etiya.reCapProject.entities.requests.UpdateRentAlRequest;

@Service
public class RentAlManager implements RentAlService{
	
	private RentAlDao rentAlDao;
	
	@Autowired
	public RentAlManager(RentAlDao rentAlDao) {
		super();
		this.rentAlDao = rentAlDao;
	}

	@Override
	public DataResult<List<RentAl>> getAll() {
		List<RentAl> rentals= this.rentAlDao.findAll();
		return new SuccessDataResult<List<RentAl>>(rentals,Messages.List);
	}

	@Override
	public DataResult<RentAl> getById(int rentalId) {
		RentAl rentals= this.rentAlDao.getById(rentalId);
		return new SuccessDataResult<RentAl>(rentals,Messages.Listed);
	}

	@Override
	public Result add(AddRentAlRequest addRentAlRequest) {
		
		RentAl rentAl=new RentAl();
		rentAl.setRentDate(addRentAlRequest.getRentDate());
		rentAl.setReturnDate(addRentAlRequest.getReturnDate());
		
		Customers customers=new Customers();
		customers.setCustomerId(addRentAlRequest.getCustomerId());
		
		Car car=new Car();
		car.setCarId(addRentAlRequest.getCarId());
		car.setCarName(addRentAlRequest.getCarName());
		
		rentAl.setCar(car);
		rentAl.setCustomers(customers);
		
		var result= BusinnesRules.run(checkCarIsSubmit(rentAl.getCar().getCarId()));
		if (result!=null) {
			return result;
		}
		
		this.rentAlDao.save(rentAl);
		return new SuccessResult(Messages.Add);
	}

	@Override
	public Result update(UpdateRentAlRequest updateRentAlRequest) {
		
		RentAl rentAl=new RentAl();
		rentAl.setRentDate(updateRentAlRequest.getRentDate());
		rentAl.setReturnDate(updateRentAlRequest.getReturnDate());
		
		Customers customers=new Customers();
		customers.setCustomerId(updateRentAlRequest.getCustomerId());
		
		
		Car car=new Car();
		car.setCarId(updateRentAlRequest.getCarId());
		car.setCarName(updateRentAlRequest.getCarName());

		
		rentAl.setCar(car);
		rentAl.setCustomers(customers);
		
		
		this.rentAlDao.save(rentAl);
		return new SuccessResult(Messages.Update);
	}

	@Override
	public Result delete(DeleteRentAlRequest deleteRentAlRequest) {
		
		RentAl rentAl=new RentAl();
		rentAl.setRentAlId(deleteRentAlRequest.getRentAlId());
		
		Customers customers=new Customers();
		customers.setCustomerId(deleteRentAlRequest.getCustomerId());
		
		Car car=new Car();
		car.setCarId(deleteRentAlRequest.getCarId());

		
		this.rentAlDao.delete(rentAl);
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

}
