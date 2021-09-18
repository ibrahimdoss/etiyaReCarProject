package com.etiya.reCapProject.business.abstracts;

import java.util.List;

import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.entities.concretes.ApplicationUser;
import com.etiya.reCapProject.entities.requests.AddApplicationUser;
import com.etiya.reCapProject.entities.requests.DeleteApplicationUser;
import com.etiya.reCapProject.entities.requests.UpdateApplicationUser;

public interface ApplicationUserService {
	
	DataResult<List<ApplicationUser>> getAll();
	
	Result add(AddApplicationUser addApplicationUser);
	
	Result update(UpdateApplicationUser updateApplicationUser);

	Result delete(DeleteApplicationUser deleteApplicationUser);

}
