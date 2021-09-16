package com.etiya.reCapProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.reCapProject.business.abstracts.CarService;
import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.entities.concretes.Car;
import com.etiya.reCapProject.entities.dtos.CarDetailsDto;

@RestController
@RequestMapping("/api/cars")
public class CarsControllers {
	
	private CarService carService;
	
	@Autowired
	public CarsControllers(CarService carService) {
		super();
		this.carService = carService;
	}
	
	@GetMapping("/getcarıd")
	public DataResult<List<Car>> getById(int id) {
		return this.carService.getById(id);
		
	}
	
	@GetMapping("/getallcar")
	public DataResult<List<Car>> getAll() {
		return this.carService.getAll();
		
	}
	
	@GetMapping("/getcarwithdetail")
	public DataResult<List<CarDetailsDto>> getCarWithDetails() {
		return this.carService.getCarWithDetails();
	}

	
	
	@PostMapping("/addcar")
	public Result add(@RequestBody Car car) {
		return this.carService.add(car);
	}

	@PostMapping("/updatecar")
	public Result update(@RequestBody Car car) {
		return this.carService.update(car);
	}
	
	@DeleteMapping("/deletecar")
	public Result delete(@RequestBody  Car car) {
		return this.carService.delete(car);
	}


	
}
