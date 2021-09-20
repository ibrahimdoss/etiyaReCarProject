package com.etiya.reCapProject.entities.requests;


import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddCarImagesRequest {
	
	
	
	
	@NotNull(message = "Boş Geçilemez!")
	private int carId;


}
