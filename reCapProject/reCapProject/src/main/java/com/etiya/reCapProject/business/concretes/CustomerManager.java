package com.etiya.reCapProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.reCapProject.business.abstracts.CustomerService;
import com.etiya.reCapProject.business.constants.Messages;
import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.core.utilities.results.SuccessDataResult;
import com.etiya.reCapProject.core.utilities.results.SuccessResult;
import com.etiya.reCapProject.dataAccess.abstracts.CustomerDao;
import com.etiya.reCapProject.entities.concretes.ApplicationUser;
import com.etiya.reCapProject.entities.concretes.Customers;
import com.etiya.reCapProject.entities.requests.AddCustomerRequest;
import com.etiya.reCapProject.entities.requests.DeleteCustomerRequest;
import com.etiya.reCapProject.entities.requests.UpdateCustomerRequest;

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
		return new SuccessDataResult<List<Customers>>(customers,Messages.List);
	}

	@Override
	public Result add(AddCustomerRequest addCustomerRequest) {
		
		Customers customers = new Customers();
		customers.setCompanyName(addCustomerRequest.getCompanyName());
		
		ApplicationUser applicationUser= new ApplicationUser();
		applicationUser.setId(addCustomerRequest.getId());
		
		customers.setApplicationUser(applicationUser);

		
		this.customerDao.save(customers);
		return new SuccessResult(Messages.Add);
	}

	@Override
	public Result update(UpdateCustomerRequest updateCustomerRequest) {
		
		Customers customers = new Customers();
		customers.setCompanyName(updateCustomerRequest.getCompanyName());
		
		ApplicationUser applicationUser= new ApplicationUser();
		applicationUser.setId(updateCustomerRequest.getId());
		
		customers.setApplicationUser(applicationUser);

		
		this.customerDao.save(customers);
		return new SuccessResult(Messages.Update);
	}

	@Override
	public Result delete(DeleteCustomerRequest deleteCustomerRequest) {
		
		Customers customers = new Customers();
		customers.setCustomerId(deleteCustomerRequest.getCustomerId());
		
		ApplicationUser applicationUser= new ApplicationUser();
		applicationUser.setId(deleteCustomerRequest.getId());
		
		customers.setApplicationUser(applicationUser);

		
		this.customerDao.delete(customers);
		return new SuccessResult(Messages.Delete);
	}

}
