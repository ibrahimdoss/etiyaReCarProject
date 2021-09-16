package com.etiya.reCapProject.business.abstracts;

import java.util.List;

import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.entities.concretes.RentAl;

public interface RentAlService {
	
	DataResult<List<RentAl>> getAll();
	
	DataResult<RentAl> getById(int rentalId);
	
	Result add(RentAl rentAl);
	
	Result update(RentAl rentAl);

	Result delete(RentAl rentAl);

}
