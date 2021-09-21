package com.etiya.reCapProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.reCapProject.business.abstracts.ApplicationUserService;
import com.etiya.reCapProject.business.constants.Messages;
import com.etiya.reCapProject.core.utilities.businnes.BusinnesRules;
import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.ErrorResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.core.utilities.results.SuccessDataResult;
import com.etiya.reCapProject.core.utilities.results.SuccessResult;
import com.etiya.reCapProject.dataAccess.abstracts.ApplicationUserDao;
import com.etiya.reCapProject.entities.concretes.ApplicationUser;
import com.etiya.reCapProject.entities.dtos.UserLoginDto;
import com.etiya.reCapProject.entities.dtos.UserRegisterDto;
import com.etiya.reCapProject.entities.requests.AddApplicationUser;
import com.etiya.reCapProject.entities.requests.DeleteApplicationUserRequest;
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
	public Result delete(DeleteApplicationUserRequest deleteApplicationUserRequest) {
		ApplicationUser applicationUser= new ApplicationUser();
		applicationUser.setId(deleteApplicationUserRequest.getId());
		
		this.userDao.delete(applicationUser);
		return new SuccessResult(Messages.Delete);
		
		
	}

	@Override
	public Result userLogin(UserLoginDto userLoginDto) {
		ApplicationUser applicationUser = new ApplicationUser();
		applicationUser.setEMail(userLoginDto.getEMail());
		applicationUser.setPassword(userLoginDto.getPassword());
		
		this.userDao.save(applicationUser);
		return new SuccessResult(Messages.Add);
	}

	@Override
	public Result userRegister(UserRegisterDto userRegisterDto) {
		
		ApplicationUser applicationUser = new ApplicationUser();
		applicationUser.setEMail(userRegisterDto.getEMail());
		applicationUser.setPassword(userRegisterDto.getPassword());
		applicationUser.setFirstName(userRegisterDto.getFirstName());
		applicationUser.setLastName(userRegisterDto.getLastName());
		
		var result= BusinnesRules.run(checkEmailRegister(applicationUser));
		
		if (result!=null) {
			return result;
		}
		
		this.userDao.save(applicationUser);
		return new SuccessResult(Messages.Add);
	}

	@Override
	public DataResult<ApplicationUser> getById(int id) {
		return new SuccessDataResult<ApplicationUser>(this.userDao.getById(id),Messages.Listed);
	}
	
	
	
	private Result checkEmailRegister(ApplicationUser applicationUser) {
		for (String eMail : this.userDao.getEmail()) {
				if (eMail.equals(applicationUser.getEMail())) {
					return new ErrorResult(Messages.RegisterError);
				}
				
		}
		return new SuccessResult();

		
	}

}
