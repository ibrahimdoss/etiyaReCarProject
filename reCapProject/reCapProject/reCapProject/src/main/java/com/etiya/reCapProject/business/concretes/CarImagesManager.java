package com.etiya.reCapProject.business.concretes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.etiya.reCapProject.business.abstracts.CarImagesService;
import com.etiya.reCapProject.business.constants.Messages;
import com.etiya.reCapProject.core.utilities.businnes.BusinnesRules;
import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.ErrorDataResult;
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
	public DataResult<List<CarImages>> getAll() {
		return new SuccessDataResult<List<CarImages>>(this.carImageDao.findAll(),Messages.List);
	}

	

	@Override
	public Result add(AddCarImagesRequest addCarImagesRequest, MultipartFile file) throws IOException {
		
		var result= BusinnesRules.run(checkImageIsNull(file),checkIfCarImagesAddController(addCarImagesRequest.getCarId(), 5));
		if (result!=null) {
			return result;
		}
		
		Date dateNow= new java.sql.Date(new java.util.Date().getTime());
		String randomImageName=UUID.randomUUID().toString();
		
		File myFiles= new File("C:\\Users\\ibrahim.dos\\Desktop\\img\\"+randomImageName+".");
		myFiles.createNewFile();
		FileOutputStream fls=new FileOutputStream(myFiles);
		//byte olarak yazıyor içini yazıyor.
		fls.write(file.getBytes());
		fls.close();
		
		Car car = new Car();
		car.setCarId(addCarImagesRequest.getCarId());
		
		CarImages carImages = new CarImages();
		carImages.setImagePath(myFiles.toString());
		carImages.setDate(dateNow);
		carImages.setCar(car);
		
		this.carImageDao.save(carImages);
		return new SuccessResult( Messages.Add);
	}

	@Override
	public Result update(UpdateCarImagesRequest updateCarImagesRequest, MultipartFile file) throws IOException{
		var result= BusinnesRules.run(checkImageIsNull(file),checkIfCarImagesAddController(updateCarImagesRequest.getCarId(), 5));
		if (result!=null) {
			return result;
		}
		
		Date dateNow= new java.sql.Date(new java.util.Date().getTime());
		String randomImageName=UUID.randomUUID().toString();
		
		File myFiles= new File("C:\\Users\\ibrahim.dos\\Desktop\\img\\"+randomImageName+".");
		myFiles.createNewFile();
		FileOutputStream fls=new FileOutputStream(myFiles);
		//byte olarak yazıyor içini yazıyor.
		fls.write(file.getBytes());
		fls.close();
		
		Car car = new Car();
		car.setCarId(updateCarImagesRequest.getCarId());
		
		CarImages carImages = new CarImages();
		carImages.setId(updateCarImagesRequest.getId());
		
		carImages.setCar(car);
		
		this.carImageDao.save(carImages);
		return new SuccessResult(Messages.Update);
	}

	@Override
	public Result delete(DeleteCarImagesRequest deleteCarImagesRequest) {
		
		Car car = new Car();
		car.setCarId(deleteCarImagesRequest.getCarId());
		
		CarImages carImages = new CarImages();
		carImages.setId(deleteCarImagesRequest.getId());
		
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
	
	
	

	

	
	private Result checkImageIsNull(MultipartFile file) {
		if (file == null) {
			return new ErrorResult(Messages.ImageNullError);
		}
		return new SuccessResult();
	}



	@Override
	public DataResult<List<CarImages>> getCarImagesByCarId(int carId) {
		return new SuccessDataResult<List<CarImages>>(returnCarImageWithDefaultImageIfCarImageIsNull(carId).getData(),
				Messages.Listed);
	}
	
	
	private DataResult<List<CarImages>> returnCarImageWithDefaultImageIfCarImageIsNull(int carId) {

		if (this.carImageDao.existsByCar_CarId(carId)) {
			return new ErrorDataResult<List<CarImages>>(this.carImageDao.getByCar_CarId(carId));
		}

		List<CarImages> carImages = new ArrayList<CarImages>();
		CarImages carImage = new CarImages();
		carImage.setImagePath("C:\\Users\\ibrahim.dos\\Desktop\\img\\default.png");

		carImages.add(carImage);

		return new SuccessDataResult<List<CarImages>>(carImages, Messages.DefaultMsg);

	}
	

}
