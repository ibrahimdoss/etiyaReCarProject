package com.etiya.reCapProject.business.abstracts;

import java.util.List;

import com.etiya.reCapProject.core.entities.concretes.Users;
import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;

public interface UserService {
	
	DataResult<List<Users>> getAll();
	
	Result add(Users users);
	
	Result update(Users users);

	Result delete(Users users);

}
