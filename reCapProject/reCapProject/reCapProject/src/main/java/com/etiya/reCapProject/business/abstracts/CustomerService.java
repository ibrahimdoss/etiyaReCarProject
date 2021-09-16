package com.etiya.reCapProject.business.abstracts;

import java.util.List;

import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.entities.concretes.Customers;

public interface CustomerService {
	
	DataResult<List<Customers>> getAll();
	
	Result add(Customers customers);
	
	Result update(Customers customers);
	
	Result delete(Customers customers);
}
