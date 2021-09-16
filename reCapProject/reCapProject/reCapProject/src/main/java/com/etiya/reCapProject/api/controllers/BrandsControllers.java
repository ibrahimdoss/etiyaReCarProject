package com.etiya.reCapProject.api.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.reCapProject.business.abstracts.BrandService;
import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.entities.concretes.Brand;

@RestController
@RequestMapping("/api/brands")
public class BrandsControllers {
	
	private BrandService brandService;
	
	@Autowired
	public BrandsControllers(BrandService brandService) {
		super();
		this.brandService = brandService;
	}
	
	@GetMapping("/getbrandıd")
	public DataResult<List<Brand>> getByBrandId(int brandId) {
		return this.brandService.getByBrandId(brandId);
		
	}
	
	@GetMapping("/getallbrand")
	public DataResult<List<Brand>> getAll() {
		return this.brandService.getAll();
		
	}
	
	@PostMapping("/addbrand")
	public Result add(@RequestBody Brand brand) {
		return this.brandService.add(brand);
	}
	
	@PostMapping("/updatebrand")
	public Result update(@RequestBody Brand brand) {
		return this.brandService.update(brand);
	}
	
	@DeleteMapping("/deletebrand")
	public Result delete(@RequestBody Brand brand) {
		return this.brandService.delete(brand);
		
	}




}
