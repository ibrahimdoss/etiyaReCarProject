package com.etiya.reCapProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.reCapProject.business.abstracts.RentAlService;
import com.etiya.reCapProject.core.utilities.businnes.BusinnesRules;
import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.ErrorResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.core.utilities.results.SuccessDataResult;
import com.etiya.reCapProject.core.utilities.results.SuccessResult;
import com.etiya.reCapProject.dataAccess.abstracts.RentAlDao;
import com.etiya.reCapProject.entities.concretes.RentAl;

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
		return new SuccessDataResult<List<RentAl>>(rentals,"Bilgiler Listelendi");
	}

	@Override
	public DataResult<RentAl> getById(int rentalId) {
		RentAl rentals= this.rentAlDao.getById(rentalId);
		return new SuccessDataResult<RentAl>(rentals,"Id'e göre listelendi");
	}

	@Override
	public Result add(RentAl rentAl) {
		var result= BusinnesRules.run(checkCarIsSubmit(rentAl.getCar().getCarId()));
		if (result!=null) {
			return result;
		}
		
		this.rentAlDao.save(rentAl);
		return new SuccessResult("Bilgiler Eklendi");
	}

	@Override
	public Result update(RentAl rentAl) {
		this.rentAlDao.save(rentAl);
		return new SuccessResult("Bilgi Güncellendi");
	}

	@Override
	public Result delete(RentAl rentAl) {
		this.rentAlDao.delete(rentAl);
		return new SuccessResult("Bilgi Silindi");
	}
	
	public Result checkCarIsSubmit(int carId) {
		for (RentAl rental : this.rentAlDao.getByCar_CarId(carId)) {
			if(rental.getReturnDate() == null ) {
				return new ErrorResult("Araç Teslim Edilemez.");
			}
		}
		return new SuccessResult();
	}

}
