package com.etiya.reCapProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.reCapProject.business.abstracts.RentAlService;
import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.entities.concretes.RentAl;

@RestController
@RequestMapping("/api/rentals")
public class RentAlsControllers {
	
	private RentAlService rentAlService;
	
	@Autowired
	public RentAlsControllers(RentAlService rentAlService) {
		super();
		this.rentAlService = rentAlService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<RentAl>> getAll() {
		return this.rentAlService.getAll();
		
	}
	
	@GetMapping("/getbyıd")
	public DataResult<RentAl> getById(int rentalId) {
		
		return this.rentAlService.getById(rentalId);
		
	}
	
	@PostMapping("/rentaladd")
	public Result add(@RequestBody  RentAl rentAl) {
		return this.rentAlService.add(rentAl);
	}
	
	@PostMapping("/rentalupdate")
	public Result update(@RequestBody RentAl rentAl) {
		return this.rentAlService.add(rentAl);
	}
	
	@DeleteMapping("/rentaldelete")
	public Result delete(@RequestBody   RentAl rentAl) {
		return this.rentAlService.delete(rentAl);
	}
	
	
	
	
}
