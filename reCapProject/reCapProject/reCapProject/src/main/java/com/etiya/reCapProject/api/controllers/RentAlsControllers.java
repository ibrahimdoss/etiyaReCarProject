package com.etiya.reCapProject.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.reCapProject.business.abstracts.RentAlService;
import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.entities.concretes.RentAl;
import com.etiya.reCapProject.entities.requests.rentalRequest.AddRentAlRequest;
import com.etiya.reCapProject.entities.requests.rentalRequest.UpdateRentAlRequest;

@RestController
@RequestMapping("/api/rentals")
public class RentAlsControllers {
	
	private RentAlService rentAlService;
	
	@Autowired
	public RentAlsControllers(RentAlService rentAlService) {
		super();
		this.rentAlService = rentAlService;
	}
	
	@PostMapping("/addrentalforindividualcustomer")
	public Result addRentalForIndividualCustomer(@Valid @RequestBody AddRentAlRequest addRentalRequest) {
		return this.rentAlService.addRentalForIndividualCustomer(addRentalRequest);
	}
	
	@PostMapping("/updaterentalforindividualcustomer")
	public Result updateRentalForIndividualCustomer(@Valid @RequestBody UpdateRentAlRequest updateRentalRequest) {
		return this.rentAlService.updateRentalForIndividualCustomer(updateRentalRequest);
	}
	
	@PostMapping("/addrentalforcorporatecustomer")
	public Result addRentalForCorporateCustomer(@Valid @RequestBody AddRentAlRequest addRentalRequest) {
		return this.rentAlService.addRentalForCorporateCustomer(addRentalRequest);
	}
	
	@PostMapping("/updaterentalforcopporatecustomer")
	public Result updateRentalForCorporateCustomer(@Valid @RequestBody UpdateRentAlRequest updateRentalRequest) {
		return this.rentAlService.updateRentalForCorporateCustomer(updateRentalRequest);
	}
	
	@GetMapping("/getall")
	public DataResult<List<RentAl>> getAll() {
		return this.rentAlService.getAll();
	}
	
	
	
	
}
