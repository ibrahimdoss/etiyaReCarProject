package com.etiya.reCapProject.entities.requests.carRequest;



import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
	
	@Min(0)
	@Max(1900)
	@NotNull
	private int findexPoint;

	
	private String carName;

	private int modelYear;

	private double dailyPrice;
	
	private String description;
}
