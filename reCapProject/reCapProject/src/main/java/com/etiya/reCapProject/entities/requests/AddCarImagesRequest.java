package com.etiya.reCapProject.entities.requests;

import java.util.Date;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddCarImagesRequest {
	
	@NotNull
	private String imagePath;
	
	@NotNull
	private Date date;
	
	@NotNull
	private int carId;


}
