package com.example.reCapProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reCapProject.business.abstracts.CarRepairService;
import com.example.reCapProject.business.abstracts.CarService;
import com.example.reCapProject.business.constants.Messages;
import com.example.reCapProject.core.utilities.business.BusinessRules;
import com.example.reCapProject.core.utilities.result.DataResult;
import com.example.reCapProject.core.utilities.result.Result;
import com.example.reCapProject.core.utilities.result.SuccessDataResult;
import com.example.reCapProject.core.utilities.result.SuccessResult;
import com.example.reCapProject.dataAccess.abstracts.CarRepairDao;
import com.example.reCapProject.entities.concretes.Car;
import com.example.reCapProject.entities.concretes.CarRepair;

import com.example.reCapProject.entities.request.create.CreateCarRepairRequest;

import com.example.reCapProject.entities.request.delete.DeleteCarRepairRequest;

import com.example.reCapProject.entities.request.update.UpdateCarRepairRequest;

@Service
public class CarRepairManager implements CarRepairService {

	private CarRepairDao carRepairDao;
	private CarService carService;

	@Autowired
	public CarRepairManager(CarRepairDao carRepairDao) {
		super();
		this.carRepairDao = carRepairDao;
	}

	@Override
	public DataResult<CarRepair> getById(int carRepairId) {
		return new SuccessDataResult<CarRepair>(this.carRepairDao.getById(carRepairId), Messages.REPAIRID);
	}

	@Override
	public DataResult<List<CarRepair>> getAll() {
		return new SuccessDataResult<List<CarRepair>>(this.carRepairDao.findAll(), Messages.REPAIRLIST);
	}

	@Override
	public Result add(CreateCarRepairRequest createCarRepairRequest) {
		var result = BusinessRules.run(ifCarRepairisReturned(createCarRepairRequest.getCarId()));

		if (result != null) {
			return result;
		}


		Car car = new Car();
		this.carService.getById(createCarRepairRequest.getCarId()).getData();
		car.setCarId(createCarRepairRequest.getCarId());
		

		CarRepair carRepair = new CarRepair();	
		carRepair.setRepairDescription(createCarRepairRequest.getRepairDescription());
		carRepair.setRepairDate(createCarRepairRequest.getRepairDate());
		carRepair.setRepairPrice(createCarRepairRequest.getRepairPrice());
		
		carRepair.setCar(car);

		this.carRepairDao.save(carRepair);

		return new SuccessResult(Messages.REPAIRADD);

	}

	@Override
	public Result update(UpdateCarRepairRequest updateCarRepairRequest) {

		CarRepair carRepair = this.carRepairDao.getById(updateCarRepairRequest.getCarRepairId());
		carRepair.setRepairDate(updateCarRepairRequest.getRepairDate());
		carRepair.setRepairPrice(updateCarRepairRequest.getRepairPrice());
		carRepair.setRepairDescription(updateCarRepairRequest.getRepairDescription());

		this.carRepairDao.save(carRepair);

		return new SuccessResult(Messages.REPAIRUPDATE);

	}

	@Override
	public Result delete(DeleteCarRepairRequest deleteCarRepairRequest) {
		CarRepair carRepair = this.carRepairDao.getById(deleteCarRepairRequest.getCarRepairId());
		this.carRepairDao.delete(carRepair);
		return new SuccessResult(Messages.REPAIRDELETE);
	}

	public Result ifCarRepairisReturned(int carRepairId) {
		CarRepair carRepair = this.carRepairDao.getById(carRepairId);
		carRepair.setCarRepairControl(true);

		this.carService.carListedIsTrue(carRepair.getCar().getCarId());

		this.carRepairDao.save(carRepair);
		return new SuccessResult(Messages.SUCCESS);
	}

}
