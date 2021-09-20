package com.etiya.reCapProject.entities.requests;

import java.util.Date;

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
	
	
	private String imagePath;
	
	private Date date;
	
	@NotNull(message = "Boş Geçilemez!")
	private int carId;


}
