package com.etiya.reCapProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.reCapProject.business.abstracts.CarService;
import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.core.utilities.results.SuccessDataResult;
import com.etiya.reCapProject.core.utilities.results.SuccessResult;
import com.etiya.reCapProject.dataAccess.abstracts.CarDao;
import com.etiya.reCapProject.entities.concretes.Car;
import com.etiya.reCapProject.entities.dtos.CarDetailsDto;

@Service
public class CarManager implements CarService {
	
	private CarDao carDao;
	
	@Autowired
	public CarManager(CarDao carDao) {
		super();
		this.carDao = carDao;
	}
	

	@Override
	public DataResult<List<CarDetailsDto>> getCarWithDetails() {
		return new SuccessDataResult<List<CarDetailsDto>>(this.carDao.getCarWithDetails()+"Araba Detayları listelendi");
	}



	@Override
	public DataResult<List<Car>> getAll() {
		List<Car> cars= this.carDao.findAll();
		return new SuccessDataResult<List<Car>>(cars,"Arabalar Listelendi");
				
		
	}

	@Override
	public DataResult<List<Car>> getById(int id) {
		List<Car> cars= this.carDao.getById(id);
		return new SuccessDataResult<List<Car>>(cars,"Araba Id Listelendi");
		
	}

	@Override
	public Result add(Car car) {
		this.carDao.save(car);
		return new SuccessResult("Araba Kaydedildi");
	}

	@Override
	public Result update(Car car) {
		this.carDao.save(car);
		return new SuccessResult("Araba Güncellendi");

		
	}

	@Override
	public Result delete(Car car) {
		this.carDao.delete(car);
		return new SuccessResult("Araba Silindi");

		
	}




	
}
