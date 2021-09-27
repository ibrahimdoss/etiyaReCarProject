package com.etiya.reCapProject.entities.requests.rentalRequest;


import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRentAlRequest {
	
	@NotNull(message = "Boş Geçilemez!")
	
	private int rentAlId;

	
	
	@NotNull(message = "Boş Geçilemez!")
	
	private String carName;
	
	private String rentDate;
	
	
	private String returnDate;
	
	private String takeCity;
	
	private String returnCity;
	
	
	@NotNull(message = "Boş Geçilemez!")	
	private int carId;
	
	
	@NotNull(message = "Boş Geçilemez!")
	private int customerId;
}
