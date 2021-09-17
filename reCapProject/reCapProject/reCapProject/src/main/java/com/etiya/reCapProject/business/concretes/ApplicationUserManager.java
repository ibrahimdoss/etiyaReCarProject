package com.etiya.reCapProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.reCapProject.business.abstracts.ApplicationUserService;
import com.etiya.reCapProject.business.constants.Messages;
import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.core.utilities.results.SuccessDataResult;
import com.etiya.reCapProject.core.utilities.results.SuccessResult;
import com.etiya.reCapProject.dataAccess.abstracts.ApplicationUserDao;
import com.etiya.reCapProject.entities.concretes.ApplicationUser;
import com.etiya.reCapProject.entities.requests.AddApplicationUser;
import com.etiya.reCapProject.entities.requests.DeleteApplicationUser;
import com.etiya.reCapProject.entities.requests.UpdateApplicationUser;

@Service
public class ApplicationUserManager implements ApplicationUserService {
	
	private ApplicationUserDao userDao;
	
	@Autowired
	public ApplicationUserManager(ApplicationUserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<ApplicationUser>> getAll() {
		List<ApplicationUser> users= this.userDao.findAll();
		return new SuccessDataResult<List<ApplicationUser>>(users,Messages.List);
	}

	@Override
	public Result add(AddApplicationUser addApplicationUser) {
		
		ApplicationUser applicationUser= new ApplicationUser();
		applicationUser.setFirstName(addApplicationUser.getFirstName());
		applicationUser.setLastName(addApplicationUser.getLastName());
		applicationUser.setEMail(addApplicationUser.getEMail());
		applicationUser.setPassword(addApplicationUser.getPassword());
		
		this.userDao.save(applicationUser);
		return new SuccessResult(Messages.Add);
	}

	@Override
	public Result update(UpdateApplicationUser updateApplicationUser ) {
		
		ApplicationUser applicationUser= new ApplicationUser();
		applicationUser.setFirstName(updateApplicationUser.getFirstName());
		applicationUser.setLastName(updateApplicationUser.getLastName());
		applicationUser.setEMail(updateApplicationUser.getEMail());
		applicationUser.setPassword(updateApplicationUser.getPassword());
		
		this.userDao.save(applicationUser);
		return new SuccessResult(Messages.Update);
	}

	@Override
	public Result delete(DeleteApplicationUser deleteApplicationUser) {
		
		ApplicationUser applicationUser= new ApplicationUser();
		applicationUser.setFirstName(deleteApplicationUser.getFirstName());
		applicationUser.setLastName(deleteApplicationUser.getLastName());
		applicationUser.setEMail(deleteApplicationUser.getEMail());
		applicationUser.setPassword(deleteApplicationUser.getPassword());
		
		this.userDao.delete(applicationUser);
		return new SuccessResult(Messages.Delete);
	}

}
