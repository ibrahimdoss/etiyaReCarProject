package com.example.reCapProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.reCapProject.entities.concretes.Rental;
import com.example.reCapProject.entities.dtos.RentalDetailsDto;

public interface RentalDao extends JpaRepository<Rental, Integer> {

	@Query("Select new com.example.reCapProject.entities.dtos.RentalDetailsDto" + "(c.carId, r.returnDate) "
			+ "From Car c Inner Join c.rentals r where c.carId=:carId and r.returnDate is null")

	RentalDetailsDto getByCarIdWhereReturnDateIsNull(int carId);

	boolean existsByReturnRentControlIsFalse();

}
