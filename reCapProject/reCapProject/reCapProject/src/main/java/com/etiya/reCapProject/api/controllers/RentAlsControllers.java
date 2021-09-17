package com.etiya.reCapProject.api.controllers;

import java.util.List;

import javax.validation.Valid;

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
import com.etiya.reCapProject.entities.requests.AddRentAlRequest;
import com.etiya.reCapProject.entities.requests.DeleteRentAlRequest;
import com.etiya.reCapProject.entities.requests.UpdateRentAlRequest;

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
	public Result add(@RequestBody @Valid AddRentAlRequest addRentAlRequest) {
		return this.rentAlService.add(addRentAlRequest);
	}
	
	@PostMapping("/rentalupdate")
	public Result update(@RequestBody @Valid UpdateRentAlRequest updateRentAlRequest) {
		return this.rentAlService.update(updateRentAlRequest);
	}
	
	@DeleteMapping("/rentaldelete")
	public Result delete(@RequestBody @Valid DeleteRentAlRequest deleteRentAlRequest ) {
		return this.rentAlService.delete(deleteRentAlRequest);
	}
	
	
	
	
}
