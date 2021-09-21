package com.etiya.reCapProject.business.abstracts;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.entities.concretes.CarImages;
import com.etiya.reCapProject.entities.requests.AddCarImagesRequest;
import com.etiya.reCapProject.entities.requests.DeleteCarImagesRequest;
import com.etiya.reCapProject.entities.requests.UpdateCarImagesRequest;

public interface CarImagesService {
	
	DataResult<List<CarImages>> getAll();
	
	
	
	DataResult<List<CarImages>> getCarImagesByCarId(int carId);

	
	Result add(AddCarImagesRequest addCarImagesRequest, MultipartFile file) throws IOException;
	
	Result update(UpdateCarImagesRequest updateCarImagesRequest,MultipartFile file) throws IOException;
	
	Result delete(DeleteCarImagesRequest deleteCarImagesRequest);
}
