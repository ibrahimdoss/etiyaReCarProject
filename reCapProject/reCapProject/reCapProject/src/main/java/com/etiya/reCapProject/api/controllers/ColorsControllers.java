package com.etiya.reCapProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.reCapProject.business.abstracts.ColorService;
import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.entities.concretes.Color;

@RestController
@RequestMapping("/api/colors")
public class ColorsControllers {
	
	private ColorService colorService;
	
	@Autowired
	public ColorsControllers(ColorService colorService) {
		super();
		this.colorService = colorService;
	}
	
	@GetMapping("/getcolorıd")
	public DataResult<List<Color>> getByColorId(int colorId) {
		return this.colorService.getByColorId(colorId);
	}
	
	@GetMapping("/getallcolor")
	public DataResult<List<Color>> getAll() {
		return this.colorService.getAll();
	}
	
	@PostMapping("/addcolor")
	public Result add(@RequestBody Color color) {
		return this.colorService.add(color);
	}
	
	@PostMapping("/updatecolor")
	public Result update(@RequestBody  Color color) {
		return this.colorService.update(color);
	}
	
	
	@DeleteMapping("/deletecolor")
	public Result delete(@RequestBody  Color color) {
		return this.colorService.delete(color);
	}


}
