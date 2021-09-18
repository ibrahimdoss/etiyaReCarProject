package com.etiya.reCapProject.business.abstracts;

import java.util.List;

import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.entities.concretes.CarImages;
import com.etiya.reCapProject.entities.requests.AddCarImagesRequest;
import com.etiya.reCapProject.entities.requests.DeleteCarImagesRequest;
import com.etiya.reCapProject.entities.requests.UpdateCarImagesRequest;

public interface CarImagesService {
	
	DataResult<List<CarImages>> getAll();
	
	DataResult<CarImages> getById(int id);
	
	DataResult<List<CarImages>> getByCar_CarId(int carId);
	
	Result add(AddCarImagesRequest addCarImagesRequest);
	
	Result update(UpdateCarImagesRequest updateCarImagesRequest);
	
	Result delete(DeleteCarImagesRequest deleteCarImagesRequest);
}
