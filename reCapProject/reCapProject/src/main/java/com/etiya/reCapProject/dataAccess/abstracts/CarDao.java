package com.etiya.reCapProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.etiya.reCapProject.entities.concretes.Car;
import com.etiya.reCapProject.entities.dtos.CarDetailsDto;

@Repository
public interface CarDao extends JpaRepository<Car, Integer>{
	
	
	@Query("Select new com.etiya.reCapProject.entities.dtos.CarDetailsDto"
			+ " (c.carName, b.brandName , cl.colorName, c.dailyPrice) " 
			+ " From Brand b Inner Join b.cars c"
			+ " Inner Join c.color cl")
	List<CarDetailsDto> getCarWithDetails();
	
	boolean existsByCarImagesIsNullAndCarId(int carId);
	
	boolean existsByCarImagesIsNull();
	
	
	
	
}