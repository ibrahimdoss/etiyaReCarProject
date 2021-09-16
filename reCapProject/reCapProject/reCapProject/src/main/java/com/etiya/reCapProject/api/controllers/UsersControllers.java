package com.etiya.reCapProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.reCapProject.business.abstracts.UserService;
import com.etiya.reCapProject.core.entities.concretes.Users;
import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;


@RestController
@RequestMapping("/api/users")
public class UsersControllers {
	
	private UserService userService;
	
	@Autowired
	public UsersControllers(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Users>> getAll() {
		return this.userService.getAll();
	}
	
	@PostMapping("/useradd")
	public Result add(@RequestBody Users users) {
		return this.userService.add(users);
	}
	
	@PostMapping("/userupdate")
	public Result update(@RequestBody Users users) {
		return this.userService.update(users);
	}
	
	@PostMapping("/userdelete")
	public Result delete(@RequestBody  Users users) {
		return this.userService.delete(users);
	}
	
	
	
	
	
	

}
