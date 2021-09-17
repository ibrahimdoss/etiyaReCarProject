package com.etiya.reCapProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.reCapProject.business.abstracts.CarService;
import com.etiya.reCapProject.business.constants.Messages;
import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.core.utilities.results.SuccessDataResult;
import com.etiya.reCapProject.core.utilities.results.SuccessResult;
import com.etiya.reCapProject.dataAccess.abstracts.CarDao;
import com.etiya.reCapProject.entities.concretes.Brand;
import com.etiya.reCapProject.entities.concretes.Car;
import com.etiya.reCapProject.entities.concretes.Color;
import com.etiya.reCapProject.entities.dtos.CarDetailsDto;
import com.etiya.reCapProject.entities.requests.AddCarRequest;
import com.etiya.reCapProject.entities.requests.DeleteCarRequest;
import com.etiya.reCapProject.entities.requests.UpdateCarRequest;

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
		return new SuccessDataResult<List<CarDetailsDto>>(this.carDao.getCarWithDetails()+ Messages.DetailsList);
	}



	@Override
	public DataResult<List<Car>> getAll() {
		List<Car> cars= this.carDao.findAll();
		return new SuccessDataResult<List<Car>>(cars,Messages.List);
				
		
	}

	@Override
	public DataResult<List<Car>> getById(int id) {
		List<Car> cars= this.carDao.getById(id);
		return new SuccessDataResult<List<Car>>(cars,Messages.Listed);
		
	}

	@Override
	public Result add(AddCarRequest addCarRequest) {
		
		Brand brand = new Brand();
		brand.setBrandId(addCarRequest.getBrandId());
		
		Color color= new Color();
		color.setColorId(addCarRequest.getColorId());
		
		Car car= new Car();
		car.setCarName(addCarRequest.getCarName());
		car.setModelYear(addCarRequest.getModelYear());
		car.setDailyPrice(addCarRequest.getDailyPrice());
		car.setDescription(addCarRequest.getDescription());
		

		car.setBrand(brand);
		car.setColor(color);
		
		this.carDao.save(car);
		return new SuccessResult(Messages.Add);
	}

	@Override
	public Result update(UpdateCarRequest updateCarRequest) {
		
		Brand brand = new Brand();
		brand.setBrandId(updateCarRequest.getBrandId());
		
		Color color= new Color();
		color.setColorId(updateCarRequest.getColorId());
		
		Car car= new Car();
		car.setCarName(updateCarRequest.getCarName());
		car.setModelYear(updateCarRequest.getModelYear());
		car.setDailyPrice(updateCarRequest.getDailyPrice());
		car.setDescription(updateCarRequest.getDescription());
		

		car.setBrand(brand);
		car.setColor(color);
		
		this.carDao.save(car);
		return new SuccessResult(Messages.Update);

		
	}

	@Override
	public Result delete(DeleteCarRequest deleteCarRequest) {
		
		Brand brand = new Brand();
		brand.setBrandId(deleteCarRequest.getBrandId());
		
		Color color= new Color();
		color.setColorId(deleteCarRequest.getColorId());
		
		Car car= new Car();
		car.setCarName(deleteCarRequest.getCarName());
		car.setModelYear(deleteCarRequest.getModelYear());
		car.setDailyPrice(deleteCarRequest.getDailyPrice());
		car.setDescription(deleteCarRequest.getDescription());
		

		car.setBrand(brand);
		car.setColor(color);
		
		this.carDao.delete(car);
		return new SuccessResult(Messages.Delete);

		
	}




	
}
