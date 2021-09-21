package com.etiya.reCapProject.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="cars")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})

public class Car {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int carId;
	
	/*
	 * @Column(name="brand_id") private int brandId;
	 * 
	 * @Column(name="color_id") private int colorId;
	 */
	
	@Column(name="car_name")
	private String carName;
	
	@Column(name="model_year")
	private int modelYear;
	
	@Column(name="daily_price")
	private double dailyPrice;
	
	@Column(name="description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="brand_id")
	private Brand brand;
	
	@Column(name = "findeks_Score")
	private int carFindeksScore;
	
	@ManyToOne
	@JoinColumn(name="color_id")
	private Color color;
	
	@JsonIgnore
	@OneToMany(mappedBy = "car")
	private List<RentAl> rentAls;
	
	@OneToMany(mappedBy="car")
	private List<CarImages> carImages;
}
