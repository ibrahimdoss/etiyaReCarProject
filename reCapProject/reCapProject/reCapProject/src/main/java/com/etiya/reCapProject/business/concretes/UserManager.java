package com.etiya.reCapProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.reCapProject.business.abstracts.UserService;
import com.etiya.reCapProject.core.dataAccess.abstracts.UserDao;
import com.etiya.reCapProject.core.entities.concretes.Users;
import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.core.utilities.results.SuccessDataResult;
import com.etiya.reCapProject.core.utilities.results.SuccessResult;

@Service
public class UserManager implements UserService {
	
	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<Users>> getAll() {
		List<Users> users= this.userDao.findAll();
		return new SuccessDataResult<List<Users>>(users,"Kullanıcılar Listelendi");
	}

	@Override
	public Result add(Users users) {
		this.userDao.save(users);
		return new SuccessResult("Kullanıcı Eklendi");
	}

	@Override
	public Result update(Users users) {
		this.userDao.save(users);
		return new SuccessResult("Kullanıcı Güncellendi");
	}

	@Override
	public Result delete(Users users) {
		this.userDao.delete(users);
		return new SuccessResult("Kullanıcı Silindi");
	}

}
