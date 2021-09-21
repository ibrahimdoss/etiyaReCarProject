package com.etiya.reCapProject.entities.requests;



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
public class UpdateCarRequest {
	
	@NotNull(message = "Boş Geçilemez!")
	@NotBlank
	private int brandId;
	
	
	@NotNull(message = "Boş Geçilemez!")
	@NotBlank
	private int colorId;
	
	@NotNull(message = "Boş Geçilemez")
	private int carFindeksScore;
	
	private String carName;

	private int modelYear;

	private double dailyPrice;
	
	private String description;
}
