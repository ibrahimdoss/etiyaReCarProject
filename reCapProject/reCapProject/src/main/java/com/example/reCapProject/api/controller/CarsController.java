package com.example.reCapProject.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.reCapProject.business.abstracts.CarService;
import com.example.reCapProject.core.utilities.result.DataResult;
import com.example.reCapProject.core.utilities.result.Result;
import com.example.reCapProject.entities.concretes.Car;
import com.example.reCapProject.entities.dtos.CarDetailDto;
import com.example.reCapProject.entities.request.create.CreateCarRequest;
import com.example.reCapProject.entities.request.delete.DeleteCarRequest;
import com.example.reCapProject.entities.request.update.UpdateCarRequest;

@RestController
@RequestMapping("api/cars")
public class CarsController {

	CarService carService;

	@Autowired
	public CarsController(CarService carService) {
		super();
		this.carService = carService;
	}

	@GetMapping("/getall")
	public DataResult<List<Car>> getAll() {
		return this.carService.getAll();
	}
	
	@GetMapping("/getbyid")
	public DataResult<Car> getById(int carId) {
		return this.carService.getById(carId);
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody CreateCarRequest createCarRequest) {
		return this.carService.add(createCarRequest);
	}
	
	
	@GetMapping("/getcarwithdetails")
	public DataResult<List<CarDetailDto>>getCarWithDetails() {
		return this.carService.getCarWithDetails();
	}
	
	@PostMapping("/update")
	public Result update(@Valid @RequestBody UpdateCarRequest updateCarRequest) {
		return this.carService.update(updateCarRequest);
	}

	@PutMapping("/delete")
	public Result delete(DeleteCarRequest deleteCarRequest) {
		return this.carService.delete(deleteCarRequest);
	}
	
	@GetMapping("/getbybrandname")
	public DataResult<List<Car>>  getByBrandName(String brandName ) {
		return this.carService.getByBrandName(brandName);
	}
	
	@GetMapping("/getbycolorname")
	public DataResult<List<Car>> getByColorName(String colorName){
		return this.carService.getByColorName(colorName);
		
	}
	
	

}
