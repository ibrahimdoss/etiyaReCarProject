package com.etiya.reCapProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.reCapProject.business.abstracts.CarDamageService;
import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.entities.concretes.CarDamage;
import com.etiya.reCapProject.entities.requests.carDamageRequest.AddCarDamageRequest;
import com.etiya.reCapProject.entities.requests.carDamageRequest.DeleteCarDamageRequest;
import com.etiya.reCapProject.entities.requests.carDamageRequest.UpdateCarDamageRequest;

@RestController
@RequestMapping("/api/cardamages")
public class CarDamagesControllers {
	
	private CarDamageService carDamageService;
	
	@Autowired
	public CarDamagesControllers(CarDamageService carDamageService) {
		super();
		this.carDamageService = carDamageService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<CarDamage>> getAll() {
		return this.carDamageService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(AddCarDamageRequest addCarDamageRequest) {
		
		return this.carDamageService.add(addCarDamageRequest);
		
	}
	
	@PostMapping("/update")
	public Result update(UpdateCarDamageRequest updateCarDamageRequest) {
		return this.carDamageService.update(updateCarDamageRequest);
	}
	
	@DeleteMapping("/delete")
	public Result delete(DeleteCarDamageRequest deleteCarDamageRequest) {
		return this.carDamageService.delete(deleteCarDamageRequest);
	}



}
