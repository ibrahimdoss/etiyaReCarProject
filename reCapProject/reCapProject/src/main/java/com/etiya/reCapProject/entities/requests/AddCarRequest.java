package com.etiya.reCapProject.entities.requests;

import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddCarRequest {
	
	@NotNull
	@NotBlank
	private int brandId;
	
	@NotNull
	@NotBlank
	private int colorId;
	
	@NotNull
	@NotBlank
	private String carName;
	
	@NotNull
	@NotBlank
	private int modelYear;
	
	@NotNull
	@NotBlank
	private double dailyPrice;
	
	@NotNull
	@NotBlank
	private String description;

	

}
