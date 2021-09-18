package com.etiya.reCapProject.business.concretes;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.reCapProject.business.abstracts.CarImagesService;
import com.etiya.reCapProject.business.constants.Messages;
import com.etiya.reCapProject.core.utilities.businnes.BusinnesRules;
import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.ErrorResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.core.utilities.results.SuccessDataResult;
import com.etiya.reCapProject.core.utilities.results.SuccessResult;
import com.etiya.reCapProject.dataAccess.abstracts.CarImageDao;
import com.etiya.reCapProject.entities.concretes.Car;
import com.etiya.reCapProject.entities.concretes.CarImages;
import com.etiya.reCapProject.entities.requests.AddCarImagesRequest;
import com.etiya.reCapProject.entities.requests.DeleteCarImagesRequest;
import com.etiya.reCapProject.entities.requests.UpdateCarImagesRequest;


@Service
public class CarImagesManager implements CarImagesService{
	
	private CarImageDao carImageDao;
	
	@Autowired
	public CarImagesManager(CarImageDao carImageDao) {
		super();
		this.carImageDao = carImageDao;
	}
	
	@Override
	public DataResult<List<CarImages>> getByCar_CarId(int carId) {
		return new SuccessDataResult<List<CarImages>>(this.carImageDao.getByCar_CarId(carId),Messages.Listed);
	}
	
	@Override
	public DataResult<List<CarImages>> getAll() {
		return new SuccessDataResult<List<CarImages>>(this.carImageDao.findAll(),Messages.List);
	}

	@Override
	public DataResult<CarImages> getById(int id) {
		return new SuccessDataResult<CarImages>(this.carImageDao.getById(id),Messages.Listed);
	}

	@Override
	public Result add(AddCarImagesRequest addCarImagesRequest) {
		
		var result= BusinnesRules.run(checkIfCarImagesAddController(addCarImagesRequest.getCarId(), 5));
		if (result!=null) {
			return result;
		}
		
		String randomImageName=UUID.randomUUID().toString();
		
		Car car = new Car();
		car.setCarId(addCarImagesRequest.getCarId());
		
		CarImages carImages = new CarImages();
		carImages.setImagePath("carImages/"+randomImageName+"jpg");
		carImages.setDate(addCarImagesRequest.getDate());
		
		carImages.setCar(car);
		
		this.carImageDao.save(carImages);
		return new SuccessResult( Messages.Add);
	}

	@Override
	public Result update(UpdateCarImagesRequest updateCarImagesRequest) {
		
		Car car = new Car();
		car.setCarId(updateCarImagesRequest.getCarId());
		
		CarImages carImages = new CarImages();
		carImages.setImagePath(updateCarImagesRequest.getImagePath());
		carImages.setDate(updateCarImagesRequest.getDate());
		
		carImages.setCar(car);
		
		this.carImageDao.save(carImages);
		return new SuccessResult(Messages.Update);
	}

	@Override
	public Result delete(DeleteCarImagesRequest deleteCarImagesRequest) {
		
		Car car = new Car();
		car.setCarId(deleteCarImagesRequest.getCarId());
		
		CarImages carImages = new CarImages();
		carImages.setImagePath(deleteCarImagesRequest.getImagePath());
		carImages.setDate(deleteCarImagesRequest.getDate());
		
		carImages.setCar(car);
		
		this.carImageDao.delete(carImages);
		return new SuccessResult(Messages.Delete);
	}
	
	
	private Result checkIfCarImagesAddController(int carId, int limit) {
		
		if (this.carImageDao.countByCar_CarId(carId)>limit) {
			return new ErrorResult(Messages.ImageError);
		}
		
		return new SuccessResult();
	}

	

}
