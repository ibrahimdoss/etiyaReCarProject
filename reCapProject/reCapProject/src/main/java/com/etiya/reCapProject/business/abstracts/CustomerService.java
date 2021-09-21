package com.etiya.reCapProject.business.abstracts;

import java.util.List;

import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.entities.concretes.Customers;
import com.etiya.reCapProject.entities.requests.AddCustomerRequest;
import com.etiya.reCapProject.entities.requests.DeleteCustomerRequest;
import com.etiya.reCapProject.entities.requests.UpdateCustomerRequest;

public interface CustomerService {
	
	DataResult<List<Customers>> getAll();
	
	Result add(AddCustomerRequest addCustomerRequest);
	
	Result update(UpdateCustomerRequest updateCustomerRequest);
	
	Result delete(DeleteCustomerRequest deleteCustomerRequest);
	
	DataResult<Customers> getById(int id);
}
