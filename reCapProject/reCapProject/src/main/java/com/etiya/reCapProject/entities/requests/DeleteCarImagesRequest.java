package com.etiya.reCapProject.entities.requests;

import java.util.Date;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeleteCarImagesRequest {
	
	
	private String imagePath;
	
	
	private Date date;
	
	
	private int carId;
}
