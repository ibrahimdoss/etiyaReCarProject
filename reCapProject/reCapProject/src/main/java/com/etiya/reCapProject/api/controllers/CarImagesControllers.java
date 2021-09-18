package com.etiya.reCapProject.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.reCapProject.business.abstracts.CarImagesService;
import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.entities.concretes.CarImages;
import com.etiya.reCapProject.entities.requests.AddCarImagesRequest;
import com.etiya.reCapProject.entities.requests.DeleteCarImagesRequest;
import com.etiya.reCapProject.entities.requests.UpdateCarImagesRequest;

@RestController
@RequestMapping("/api/images")
public class CarImagesControllers {
	
	private CarImagesService carImagesService;
	
	@Autowired
	public CarImagesControllers(CarImagesService carImagesService) {
		super();
		this.carImagesService = carImagesService;
	}
	
	
	@GetMapping("/getall")
	public DataResult<List<CarImages>> getAll() {
		return this.carImagesService.getAll();
	}
	
	@GetMapping("/getbycarid")
	public DataResult<List<CarImages>> getByCar_CarId(int carId){
		return this.carImagesService.getByCar_CarId(carId);
	}
	@GetMapping("/getcarimagesbyid")
	public DataResult<CarImages> getById(int id) {
		return this.carImagesService.getById(id);
	}
	
	@PostMapping("/addcarimages")
	public ResponseEntity<?> add(@Valid @RequestBody   AddCarImagesRequest addCarImagesRequest) {
		return ResponseEntity.ok(this.carImagesService.add(addCarImagesRequest));
	}
	
	@PostMapping("/updatecarimages")
	public ResponseEntity<?> update(@Valid @RequestBody   UpdateCarImagesRequest updateCarImagesRequest) {
		return ResponseEntity.ok(this.carImagesService.update(updateCarImagesRequest));
	}
	
	
	@DeleteMapping("/deletecarimages")
	public Result delete(@RequestBody  DeleteCarImagesRequest deleteCarImagesRequest) {
		return this.carImagesService.delete(deleteCarImagesRequest);
	}
	
	
}