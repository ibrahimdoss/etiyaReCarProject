package com.etiya.reCapProject.entities.requests.rentalRequest;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Validated

public class AddRentAlRequest {
	
	@NotNull(message = "Boş Geçilemez!")
	private String rentDate;

	private String returnDate;
	
	@NotNull(message = "Boş Geçilemez!")
	private int carId;
	
	@NotNull(message = "Boş Geçilemez!")
	@NotBlank
	private String carName;
	
	@NotNull(message = "Boş Geçilemez!")
	private String takeCity;
	
	@NotNull(message = "Boş Geçilemez!")
	private String returnCity;

	
	@NotNull(message = "Boş Geçilemez!")
	private int customerId;
	
	@NotNull(message = "Boş Geçilemez!")
	private boolean saveCreditCard;

}
