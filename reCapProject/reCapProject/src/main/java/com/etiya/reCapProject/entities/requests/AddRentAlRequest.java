package com.etiya.reCapProject.entities.requests;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class AddRentAlRequest {
	
	@NotNull(message = "Boş Geçilemez!")
	private Date rentDate;

	private Date returnDate;
	
	@NotNull(message = "Boş Geçilemez!")
	private int carId;
	
	@NotNull(message = "Boş Geçilemez!")
	@NotBlank
	private String carName;
	
	@NotNull(message = "Boş Geçilemez!")
	private int customerId;

}
