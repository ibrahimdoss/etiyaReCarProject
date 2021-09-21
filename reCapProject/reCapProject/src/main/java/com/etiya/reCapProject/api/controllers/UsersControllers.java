package com.etiya.reCapProject.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.reCapProject.business.abstracts.ApplicationUserService;
import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.entities.concretes.ApplicationUser;
import com.etiya.reCapProject.entities.dtos.UserLoginDto;
import com.etiya.reCapProject.entities.dtos.UserRegisterDto;
import com.etiya.reCapProject.entities.requests.AddApplicationUser;
import com.etiya.reCapProject.entities.requests.DeleteApplicationUserRequest;
import com.etiya.reCapProject.entities.requests.UpdateApplicationUser;


@RestController
@RequestMapping("/api/users")
public class UsersControllers {
	
	private ApplicationUserService userService;
	
	@Autowired
	public UsersControllers(ApplicationUserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<ApplicationUser>> getAll() {
		return this.userService.getAll();
	}
	
	@PostMapping("/useradd")
	public Result add(@RequestBody @Valid AddApplicationUser addApplicationUser) {
		return this.userService.add(addApplicationUser);
	}
	
	@PostMapping("/userupdate")
	public Result update(@RequestBody  @Valid UpdateApplicationUser updateApplicationUser) {
		return this.userService.update(updateApplicationUser);
	}
	
	@PostMapping("/userdelete")
	public Result delete( @Valid DeleteApplicationUserRequest deleteApplicationUserRequest) {
		return this.userService.delete(deleteApplicationUserRequest);
	}
	
	@PostMapping("/userlogin")
	public ResponseEntity<?> userLogin(@Valid @RequestBody   UserLoginDto userLoginDto) {
		return ResponseEntity.ok(this.userService.userLogin(userLoginDto));
	}

	@PostMapping("/userregister")
	public ResponseEntity<?> userRegister(@Valid @RequestBody   UserRegisterDto userRegisterDto) {
		return ResponseEntity.ok(this.userService.userRegister(userRegisterDto));
	}

	
	
	
	

}
