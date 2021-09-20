package com.etiya.reCapProject.business.abstracts;

import java.util.List;

import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.entities.concretes.ApplicationUser;
import com.etiya.reCapProject.entities.dtos.UserLoginDto;
import com.etiya.reCapProject.entities.dtos.UserRegisterDto;
import com.etiya.reCapProject.entities.requests.AddApplicationUser;
import com.etiya.reCapProject.entities.requests.DeleteApplicationUserRequest;
import com.etiya.reCapProject.entities.requests.UpdateApplicationUser;

public interface ApplicationUserService {
	
	DataResult<List<ApplicationUser>> getAll();
	
	Result add(AddApplicationUser addApplicationUser);
	
	Result update(UpdateApplicationUser updateApplicationUser);

	Result delete(DeleteApplicationUserRequest deleteApplicationUserRequest);
	
	Result userLogin(UserLoginDto userLoginDto);
	
	Result userRegister(UserRegisterDto userRegisterDto);
}
