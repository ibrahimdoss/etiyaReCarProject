package com.etiya.reCapProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.reCapProject.business.abstracts.CustomerService;
import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.core.utilities.results.SuccessDataResult;
import com.etiya.reCapProject.core.utilities.results.SuccessResult;
import com.etiya.reCapProject.dataAccess.abstracts.CustomerDao;
import com.etiya.reCapProject.entities.concretes.Customers;

@Service
public class CustomerManager implements CustomerService {
	
	private CustomerDao customerDao;
	
	
	@Autowired
	public CustomerManager(CustomerDao customerDao) {
		super();
		this.customerDao = customerDao;
	}

	@Override
	public DataResult<List<Customers>> getAll() {
		List<Customers> customers= this.customerDao.findAll();
		return new SuccessDataResult<List<Customers>>(customers,"Müşteriler Listelendi");
	}

	@Override
	public Result add(Customers customers) {
		this.customerDao.save(customers);
		return new SuccessResult("Müşteris Eklendi");
	}

	@Override
	public Result update(Customers customers) {
		this.customerDao.save(customers);
		return new SuccessResult("Müşteri Güncellendi");
	}

	@Override
	public Result delete(Customers customers) {
		this.customerDao.delete(customers);
		return new SuccessResult("Müşteri Silindi");
	}

}
