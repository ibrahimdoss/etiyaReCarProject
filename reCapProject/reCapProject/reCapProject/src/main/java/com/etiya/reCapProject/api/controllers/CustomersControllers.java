package com.etiya.reCapProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.reCapProject.business.abstracts.CustomerService;
import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.entities.concretes.Customers;

@RestController
@RequestMapping("/api/customers")
public class CustomersControllers {
	
	private CustomerService customerService;
	
	@Autowired
	public CustomersControllers(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Customers>> getAll() {
		return this.customerService.getAll();
	}
	
	@PostMapping("/customeradd")
	public Result add(@RequestBody  Customers customers) {
		
		return this.customerService.add(customers);
	}
	
	@PostMapping("/customerupdate")
	public Result update(@RequestBody   Customers customers) {
		
		return this.customerService.update(customers);
	}
	
	@DeleteMapping("/customerdelete")
	public Result delete(@RequestBody    Customers customers) {
		
		return this.customerService.delete(customers);
	}

	
}
