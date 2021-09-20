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
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCarImagesRequest {
	
	@NotNull(message = "Boş Geçilemez!")
	private int id;
	
	
	@NotNull(message = "Boş Geçilemez!")
	@NotBlank
	private String imagePath;
	
	@NotNull(message = "Boş Geçilemez!")
	private Date date;
	
	@NotNull(message = "Boş Geçilemez!")
	private int carId;
}
