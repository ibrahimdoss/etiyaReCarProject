package com.etiya.reCapProject.business.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.entities.concretes.Car;
import com.etiya.reCapProject.entities.dtos.CarDetailsDto;

public interface CarService {
	
	@Query("Select new com.etiya.reCapProject.entities.dtos.CarDetailsDto"
			+ " (c.carName, b.brandName , cl.colorName, c.dailyPrice) " 
			+ " From Brand b Inner Join b.cars c"
			+ " Inner Join c.color cl")
	DataResult<List<CarDetailsDto>> getCarWithDetails();
	
	DataResult<List<Car>> getAll();

	DataResult<List<Car>> getById(int id);

	Result add(Car car);
																		
	Result update(Car car);

	Result delete(Car car);
}



