package com.etiya.reCapProject.business.abstracts;

import java.util.List;

import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.entities.concretes.RentAl;
import com.etiya.reCapProject.entities.requests.AddRentAlRequest;
import com.etiya.reCapProject.entities.requests.DeleteRentAlRequest;
import com.etiya.reCapProject.entities.requests.UpdateRentAlRequest;

public interface RentAlService {
	
	DataResult<List<RentAl>> getAll();
	
	DataResult<RentAl> getById(int rentalId);
	
	Result add(AddRentAlRequest addRentAlRequest);
	
	Result update(UpdateRentAlRequest updateRentAlRequest);

	Result delete(DeleteRentAlRequest deleteRentAlRequest);

}
